package pers.boyuan.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Json工具类
 *
 * @author ZhangBoyuan
 * @since 2025-10-21
 */
public class JSONUtils {

    private static final Random RANDOM = new Random(System.nanoTime());
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectMapper ymlMapper = new ObjectMapper(new YAMLFactory());
    private static final TypeReference<HashMap<String, Object>> hashMapTypeReference = new TypeReference<HashMap<String, Object>>() {
    };
    private static final TypeReference<TreeMap<String, Object>> treeMapTypeReference = new TypeReference<TreeMap<String, Object>>() {
    };
    private static final TypeReference<ConcurrentHashMap<String, Object>> concurrentHashMapTypeReference =
        new TypeReference<ConcurrentHashMap<String, Object>>() {
        };

    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static <T> List<T> jsonString2ListBean(String jsonString, Class<?> collectionClass, Class<T> valueType) {
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, new Class[] {valueType});
            return (List) objectMapper.readValue(jsonString, javaType);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static HashMap<String, Object> jsonString2HashMap(String jsonString) {
        try {
            return (HashMap) objectMapper.readValue(jsonString, hashMapTypeReference);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static TreeMap<String, Object> jsonString2TreeMap(String jsonString) {
        try {
            return (TreeMap) objectMapper.readValue(jsonString, treeMapTypeReference);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static ConcurrentHashMap<String, Object> jsonString2ConcurrentHashMap(String jsonString) {
        try {
            return (ConcurrentHashMap) objectMapper.readValue(jsonString, concurrentHashMapTypeReference);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static <T> T jsonString2Object(String jsonString, Class<T> valueType) {
        try {
            return (T) objectMapper.readValue(jsonString, valueType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static Object jsonString2Object(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Object.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
