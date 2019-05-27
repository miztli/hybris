package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for changing login requests
 */
public class QueryNewLogin {
    private String newLogin;
    private String password;

    public String getNewLogin() {
        return newLogin;
    }

    public void setNewLogin(String newLogin) {
        this.newLogin = newLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
