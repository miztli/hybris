/*******************************************************************************
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 ******************************************************************************/
package com.hybris.mobile.lib.commerce.helper;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * Helper for security related
 */
public class SecurityHelper {
    private static final String TAG = SecurityHelper.class.getCanonicalName();
    private static final String ALGORITHM = "AES";
    private static final String CIPHER = "AES/CBC/PKCS5Padding";
    private static final String ENCODING = "UTF8";
    private static final String INITIALIZATION_VECTOR = "e36dc751d0433f05"; // should be 16 byte length
    private static final String AES_KEY = "d2cb415e067c7b13"; // should be 16 byte length

    private static final SecretKeySpec mSecretKeySpec = new SecretKeySpec(AES_KEY.getBytes(), ALGORITHM);
    private static final IvParameterSpec mIvParameterSpec = new IvParameterSpec(INITIALIZATION_VECTOR.getBytes());


    /**
     * Get the String encrypted value associated with the key on the secure shared preferences
     *
     * @param sharedPreferences The SharedPreferences used
     * @param key               The SharedPreferences key
     * @param defaultValue      The default value if nothing if found on the SharedPreferences
     */
    public static String getStringFromSecureSharedPreferences(SharedPreferences sharedPreferences, String key, String defaultValue) {
        if (sharedPreferences == null || StringUtils.isBlank(key)) {
            throw new IllegalArgumentException();
        }

        return SecurityHelper.decrypt(sharedPreferences.getString(key, defaultValue));
    }

    /**
     * Set a String pair key/encrypted value on the secure shared preferences
     *
     * @param sharedPreferences The SharedPreferences used
     * @param key               The SharedPreferences key
     * @param value             The value to set
     */
    public static void setStringToSecureSharedPreferences(SharedPreferences sharedPreferences, String key, String value) {
        if (sharedPreferences == null || StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            throw new IllegalArgumentException();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, SecurityHelper.encrypt(value));
        editor.apply();
    }

    /**
     * Encrypt String associated with a key
     *
     * @param value The value to encrypt
     * @return encrypted string
     */
    public static String encrypt(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException();
        }

        String encryptedText = "";

        try {
            Cipher cipher = Cipher.getInstance(CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, mSecretKeySpec, mIvParameterSpec);
            encryptedText = Base64.encodeToString(cipher.doFinal(value.getBytes()), Base64.NO_CLOSE);
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "Algorithm not found.");
        } catch (NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            Log.e(TAG, "Exception during encrypt");
        } catch (InvalidKeyException e) {
            Log.e(TAG, "No valid key provided.");
        } catch (InvalidAlgorithmParameterException e) {
            Log.e(TAG, "Algorithm parameter specification is invalid");
        }

        return encryptedText;
    }

    /**
     * Decrypt secure String associated to the key
     *
     * @param value The value to decrypt
     * @return decrypted string
     */
    public static String decrypt(String value) {
        String decryptedText = "";
        try {
            if (StringUtils.isNotBlank(value)) {
                Cipher cipher = Cipher.getInstance(CIPHER);
                cipher.init(Cipher.DECRYPT_MODE, mSecretKeySpec, mIvParameterSpec);
                decryptedText = new String(cipher.doFinal(Base64.decode(value, Base64.NO_CLOSE)), ENCODING);
                return decryptedText;
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "Algorithm not found.");
        } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            Log.e(TAG, "Exception during decrypt");
        } catch (InvalidKeyException e) {
            Log.e(TAG, "No valid key provided.");
        } catch (InvalidAlgorithmParameterException e) {
            Log.e(TAG, "Algorithm parameter specification is invalid");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Character to convert is unavailable");
        }

        return decryptedText;
    }
}
