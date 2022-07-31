package pers.boyuan.common.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * easy excel 导出工具类
 *
 * @author ZhangBoyuan
 * @date 2022-07-18
 */
@Slf4j
public class EasyExcelUtil {
    public static void easyExcelWrite(HttpServletResponse response, Class<?> tClass,
                                      String fileName, String sheetName,
                                      List<?> dataList) {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), tClass)
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                    .sheet(sheetName)
                    .doWrite(dataList);
        } catch (Exception e) {
            log.error("导出excel报错:", e);
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<>(2);
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
        }
    }

}
