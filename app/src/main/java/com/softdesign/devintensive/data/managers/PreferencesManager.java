package com.softdesign.devintensive.data.managers;

import android.content.SharedPreferences;
import android.net.Uri;

import com.softdesign.devintensive.utils.ConstantManager;
import com.softdesign.devintensive.utils.DevIntensiveApplication;

import java.util.ArrayList;
import java.util.List;

public class PreferencesManager {
    private SharedPreferences mSharedPreferences;

    private static final String[] USER_FIELDS = {
            ConstantManager.USER_PHONE_KEY,
            ConstantManager.USER_MAIL_KEY,
            ConstantManager.USER_VK_KEY,
            ConstantManager.USER_GIT_KEY,
            ConstantManager.USER_BIO_KEY
    };

    public static final String[] USER_VALUES = {
            ConstantManager.USER_RATING_VALUE,
            ConstantManager.USER_CODE_LINES_VALUE,
            ConstantManager.USER_PROJECT_VALUE
    };

    public static final String[] USER_DATA = {
            ConstantManager.USER_FIRST_NAME_VALUE,
            ConstantManager.USER_LAST_NAME_VALUE,
            ConstantManager.USER_PHONE_VALUE,
            ConstantManager.USER_EMAIL_VALUE,
            ConstantManager.USER_VK_VALUE,
            ConstantManager.USER_GIT_VALUE,
            ConstantManager.USER_BIO_VALUE
    };

    public PreferencesManager(){
        this.mSharedPreferences = DevIntensiveApplication.getSharedPreferences();
    }

    public void saveUserProfileData(List<String> userFields){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for(int i = 0; i < USER_FIELDS.length; i++){
            editor.putString(USER_FIELDS[i], userFields.get(i));
        }
        editor.apply();
    }

    public List<String> loadUserProfileData(){
        List<String> userFields = new ArrayList<>();
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_PHONE_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_MAIL_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_VK_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_GIT_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_BIO_KEY, "null"));
        return userFields;
    }

    public void saveUserPhoto(Uri uri){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_PHOTO_KEY, uri.toString());
        editor.apply();
    }

    public void saveUserProfileValues(int[] userValues, String[] userData) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for(int i = 0; i < USER_VALUES.length; i++){
            editor.putString(USER_VALUES[i], String.valueOf(userValues[i]));
        }
        for(int i = 0; i < USER_DATA.length; i++) {
            editor.putString(USER_DATA[i], userData[i]);
        }
        editor.apply();
    }

    public List<String> loadUserProfileValues() {
        List<String> userValues = new ArrayList<>();
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_RATING_VALUE,"0"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_CODE_LINES_VALUE,"0"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_PROJECT_VALUE,"0"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_FIRST_NAME_VALUE,"null"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_LAST_NAME_VALUE,"null"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_PHONE_VALUE,"null"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_EMAIL_VALUE,"null"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_VK_VALUE,"null"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_GIT_VALUE,"null"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_BIO_VALUE,"null"));
        return userValues;
    }

    public Uri loadUserPhoto(){
        return Uri.parse(mSharedPreferences.getString(ConstantManager.USER_PHOTO_KEY, "android.resource://com.softdesign.devintensive/drawable/user_photo"));
    }

    public void saveAuthToken(String authToken) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.AUTH_TOKEN_KEY, authToken);
        editor.apply();
    }

    public String getAuthToken() {
        return mSharedPreferences.getString(ConstantManager.AUTH_TOKEN_KEY, "null");
    }

    public void saveUserId(String userId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_ID_KEY, userId);
        editor.apply();
    }

    public String getUserId() {
        return mSharedPreferences.getString(ConstantManager.USER_ID_KEY, "null");
    }

}
