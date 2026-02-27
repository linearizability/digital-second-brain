package pers.boyuan.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 数据脱敏工具类
 *
 * @author ZhangBoyuan
 * @date 2022-10-12
 */
public class DataMaskingUtil {

    /**
     * 开始脱敏
     *
     * @param data          待脱敏数据
     * @param beforeNumber  前保留数据位数
     * @param afterNumber   后保留数据位数
     * @param maskingNumber 中间遮盖位数
     */
    public static String encryptData(String data, Integer beforeNumber, Integer afterNumber, Integer maskingNumber) {
        if (StringUtils.isEmpty(data)) {
            return data;
        }

        String regex = "(\\w{" + beforeNumber + "})\\w*(\\w{" + afterNumber + "})";
        String replacement = "$1" + StringUtils.repeat("*", maskingNumber) + "$2";

        return data.replaceAll(regex, replacement);
    }

//    public static void main(String[] args) {
//        System.out.println(encryptData("412345678909876543", 4, 3, 1));
//    }
}
