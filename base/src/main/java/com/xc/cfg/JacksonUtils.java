package com.xc.cfg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JacksonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Logger log = LoggerFactory.getLogger(JacksonUtils.class);

    /**
     * 对象转String
     */
    public static String writeValueAsString(Object object) {
        String result = null;
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Jackson-对象转String失败，message:" + e.getMessage(), e);
        }
        return result;
    }

    /**
     * String转JsonNode
     */
    public static JsonNode readTree(String str) {
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(str);
        } catch (JsonProcessingException e) {
            log.error("Jackson-String转JsonNode失败，message:" + e.getMessage(), e);
        } catch (IOException e) {
            log.error("Jackson-String转JsonNode失败，message:" + e.getMessage(), e);
        }
        return jsonNode;
    }

    /**
     * String转对象
     */
    public static <T> T readValue(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            log.error("Jackson-String转对象失败，message:" + e.getMessage(), e);
        } catch (IOException e) {
            log.error("Jackson-String转JsonNode失败，message:" + e.getMessage(), e);
        }
        return null;
    }

    /**
     * String转List
     */
    public static <T> T readListValue(String jsonStr, TypeReference<T> valueTypeRef) {
        try {
            return objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (JsonProcessingException e) {
            log.error("Jackson-String转List失败，message:" + e.getMessage(), e);
        } catch (IOException e) {
            log.error("Jackson-String转JsonNode失败，message:" + e.getMessage(), e);
        }
        return null;
    }

    public static String getStrValue(JsonNode jsonNode, String key){
        return null == jsonNode.get(key) ? null : jsonNode.get(key).asText();
    }

}