package pers.boyuan.common.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

/**
 * 字符串解压工具类
 *
 * @author ZhangBoyuan
 * @date 2022-06-18
 */
public class StringUnzipUtil {

    /**
     * 解压gzip格式字符串
     */
    public static String gzip(String str) {
        try {
            byte[] byteArray = str.getBytes(StandardCharsets.ISO_8859_1);
            InputStream inputStream = new ByteArrayInputStream(byteArray);
            GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gzipInputStream));
            return bufferedReader
                    .lines()
                    .collect(Collectors.joining());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
