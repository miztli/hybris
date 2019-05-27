/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.lib.http.converter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.hybris.mobile.lib.http.converter.exception.DataConverterException;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Convert from JSON Data String to Java Object
 */
public abstract class JsonDataConverter implements DataConverter {

    private static final String TAG = JsonDataConverter.class.getCanonicalName();
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();


    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.b2b.converter.DataConverter#convertFrom(java.lang.Class, java.lang.String)
     */
    @Override
    public <T> T convertFrom(Class<T> className, String data) throws DataConverterException {
        if (StringUtils.isBlank(data) || className == null) {
            throw new DataConverterException("Data cannot be null");
        }

        try {
            return gson.fromJson(data, className);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, "Error with the Json conversion. Details: " + e.getLocalizedMessage());
            throw new DataConverterException(e.getLocalizedMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.b2b.converter.DataConverter#convertFrom(java.lang.Class, java.lang.String,
     * java.lang.String)
     */
    @Override
    public <T> T convertFrom(Class<T> className, String data, String property) throws DataConverterException {
        if (StringUtils.isBlank(data) || className == null || StringUtils.isBlank(property)) {
            throw new DataConverterException("Data cannot be null");
        }

        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(data).getAsJsonObject();

            if (jsonObject != null && jsonObject.get(property) != null) {
                return gson.fromJson(jsonObject.get(property), className);
            } else {
                Log.e(TAG, "Error with the Json conversion. Unknown property \"" + property + "\".");
                //throw new DataConverterException("Error with the Json conversion. Unknown property \"" + property + "\".");
                return null;
            }

        } catch (JsonSyntaxException e) {
            Log.e(TAG, "Error with the Json conversion. Details: " + e.getLocalizedMessage());
            throw new DataConverterException(e.getLocalizedMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.converter.DataConverter#convertTo(java.lang.Object)
     */
    @Override
    public String convertTo(Object data) throws DataConverterException {
        if (data == null) {
            throw new DataConverterException("Data cannot be null");
        }

        return gson.toJson(data);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.converter.DataConverter#getValuesFromProperty(java.lang.String, java.lang.String,
     * java.lang.String, boolean)
     */
    @Override
    public List<String> getValuesFromProperty(String data, String property, String element, boolean recursive) {
        return getValuesFromPropertyElement(data, property, element, recursive);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.converter.DataConverter#getValuesFromProperty(java.lang.String, java.lang.String)
     */
    @Override
    public List<String> getValuesFromProperty(String data, String property) {
        return getValuesFromPropertyElement(data, property, null, false);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.converter.DataConverter#getValues(java.lang.String, java.lang.String)
     */
    @Override
    public List<String> getValues(String data, String element) {
        return getValuesFromPropertyElement(data, null, element, false);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.converter.DataConverter#getValues(java.lang.String)
     */
    @Override
    public List<String> getValues(String data) {
        return getValuesFromPropertyElement(data, null, null, false);
    }

    /**
     * @param data     String of character to be parsed
     * @param property Attributes to be parse
     * @param element  JSON element to get data from
     * @return List of String
     */
    protected List<String> getValuesFromPropertyElement(String data, String property, String element, boolean recursive) {
        List<String> listToReturn = new ArrayList<>();

        if (data == null) {
            throw new IllegalArgumentException();
        }

        JsonParser parser = new JsonParser();

        JsonArray jsonArray;
        JsonElement jsonElement;

        try {
            if (StringUtils.isNotBlank(property)) {
                jsonElement = parser.parse(data).getAsJsonObject().get(property);
            } else {
                jsonElement = parser.parse(data);
            }

            if (jsonElement != null) {
                if (jsonElement.isJsonArray()) {
                    jsonArray = jsonElement.getAsJsonArray();
                } else {
                    jsonArray = new JsonArray();
                    jsonArray.add(jsonElement);
                }

                if (jsonArray != null) {

                    for (JsonElement currentJsonElement : jsonArray) {

                        if (StringUtils.isNotBlank(element)) {
                            if (recursive) {
                                try {
                                    listToReturn.addAll(getValuesFromPropertyElement(currentJsonElement.toString(), property, element,
                                            recursive));
                                } catch (NoSuchElementException e) {
                                    Log.d(TAG, "End of getting the recursive property " + property + ".");
                                }
                            }

                            currentJsonElement = currentJsonElement.getAsJsonObject().get(element);
                        }

                        if (currentJsonElement != null) {
                            if (currentJsonElement.isJsonPrimitive()) {
                                listToReturn.add(currentJsonElement.getAsString());
                            } else {
                                listToReturn.add(currentJsonElement.toString());
                            }
                        } else {
                            Log.d(TAG, "No data found for element " + element + ".");
                        }

                    }

                }

            } else {
                Log.d(TAG, "No data found on " + data + " for property " + property + ".");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error parsing the data " + data + " for property " + property + " and element " + element + ".");
            throw new NoSuchElementException("Error parsing the data " + data + " for property " + property + " and element "
                    + element + ".");
        }

        return listToReturn;

    }

}
