package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for changing password requests
 */
public class QueryNewPassword {

    private String old;
    private String newPassword;

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
