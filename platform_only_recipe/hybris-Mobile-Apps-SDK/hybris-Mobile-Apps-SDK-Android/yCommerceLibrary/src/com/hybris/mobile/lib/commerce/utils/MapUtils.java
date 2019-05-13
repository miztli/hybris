package com.hybris.mobile.lib.commerce.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;


public class MapUtils {

    private final static ObjectMapper mObjectMapper = new ObjectMapper();

    public static Map toMap(Object bean) {

        if (bean == null) {
            return new HashMap<>();
        } else {
            return mObjectMapper.convertValue(bean, Map.class);
        }

    }
}
