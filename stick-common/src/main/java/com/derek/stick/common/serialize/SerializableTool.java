package com.derek.stick.common.serialize;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 序列化工具
 * 
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
public class SerializableTool {

    private static final Logger logger          = LoggerFactory.getLogger(SerializableTool.class);

    private static final String JSON_START_CHAR = "[";

    private SerializableTool() {
    }

    public static <T> String serialize(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            throw new SerializeException(String.format("serialize failed. obj: %s", obj.toString()), e);
        }
    }

    public static <T> String serializeFormat(T obj) {
        return serialize(obj, SerializerFeature.PrettyFormat);
    }

    public static <T> String serializeDateFormat(T obj) {
        return serialize(obj, SerializerFeature.WriteDateUseDateFormat);
    }

    public static <T> String serializeDateAndPrettyFormat(T obj) {
        return serialize(obj, SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
    }

    public static <T> T parseObject(String jsonStr, Class<T> clazz) {
        if (StringUtils.isBlank(jsonStr) || clazz == null) {
            logger.warn("jsonStr or clazz is null. jsonStr: {}, clazz: {}", jsonStr, clazz);
            return null;
        }
        try {
            return JSON.parseObject(jsonStr, clazz);
        } catch (Exception e) {
            throw new SerializeException(String.format("parseObject failed. jsonStr: %s", jsonStr), e);
        }
    }

    public static Object parse(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            logger.warn("jsonStr is blank.");
            return null;
        }
        try {
            return JSON.parse(jsonStr);
        } catch (Exception e) {
            throw new SerializeException(String.format("parse failed. jsonStr: %s", jsonStr), e);
        }
    }

    public static Object deserialize(String jsonStr, Class<?> clazz) {
        if (StringUtils.isBlank(jsonStr) || clazz == null) {
            logger.warn("jsonStr or clazz is null. jsonStr: {}, clazz: {}", jsonStr, clazz);
            return null;
        }
        try {
            if (StringUtils.startsWith(jsonStr, JSON_START_CHAR)) {
                return JSON.parseArray(jsonStr, clazz);
            } else {
                return JSON.parseObject(jsonStr, clazz);
            }
        } catch (Exception e) {
            throw new SerializeException(String.format("deserialize failed. jsonStr: %s, clazz: %s", jsonStr,
                                                       clazz.getName()),
                                         e);
        }
    }

    private static <T> String serialize(T obj, SerializerFeature... features) {
        if (obj == null) {
            return null;
        }
        try {
            return JSON.toJSONString(obj, features);
        } catch (Exception e) {
            throw new SerializeException(String.format("serialize failed. obj: %s", obj.toString()), e);
        }
    }
}
