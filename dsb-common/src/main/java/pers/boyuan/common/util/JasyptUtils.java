package pers.boyuan.common.util;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * Jasypt加解密工具类
 *
 * @author ZhangBoyuan
 * @date 2022-07-31
 */
@Slf4j
public class JasyptUtils {

    private static final String PRIVATE_KEY = "ZhangBoyuan@ZhiFei";

    private static BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();

    static {
        basicTextEncryptor.setPassword(PRIVATE_KEY);
    }

    // 防止被实例化
    private JasyptUtils() {

    }

    /**
     * 加密
     *
     * @param plaintext 明文
     * @return 加密后字符串
     */
    public static String encrypt(String plaintext) {
        log.info("明文字符串为：{}", plaintext);
        String ciphertext = basicTextEncryptor.encrypt(plaintext);
        log.info("密文字符串为：{}", ciphertext);

        return ciphertext;
    }

    /**
     * 解密
     *
     * @param ciphertext 密文
     * @return 解密后字符串
     */
    public static String decrypt(String ciphertext) {
        log.info("密文字符串为：{}", ciphertext);
        ciphertext = "ENC(" + ciphertext + ")";
        if (PropertyValueEncryptionUtils.isEncryptedValue(ciphertext)) {
            String plaintext = PropertyValueEncryptionUtils.decrypt(ciphertext, basicTextEncryptor);
            log.info("明文字符串为：{}", plaintext);
            return plaintext;
        }
        log.error("解密失败！");
        return "";
    }

    public static void main(String[] args) {

    }

}
