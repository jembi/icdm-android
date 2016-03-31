package org.jembi.icdm.api.model;

/**
 * Created by Clive on 31 Mar 2016.
 */
public class ApiError {

    private int statusCode;
    private String message;

    public ApiError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}
