package pers.boyuan.application.tools;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pers.boyuan.application.tools.impl.ToolsAppServiceImpl;

/**
 * 常用工具汇总应用服务实现类
 *
 * @author ZhangBoyuan
 * @date 2023-02-16
 */
@Service
public class ToolsAppService implements ToolsAppServiceImpl {

    /**
     * 静态变量名生成
     *
     * @param str 待处理数据
     * @return 处理后数据
     */
    @Override
    public String staticVariableNameVariable(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return str.replace(" ", "_").toUpperCase();
    }

}
