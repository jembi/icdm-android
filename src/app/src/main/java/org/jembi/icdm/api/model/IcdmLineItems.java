package org.jembi.icdm.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Clive on 23 Mar 2016.
 */
public final class IcdmLineItems {
    @SerializedName("subtitle")
    private java.lang.String subtitle;

    public void setSubtitle(java.lang.String subtitle) {
        this.subtitle = subtitle;
    }

    public java.lang.String getSubtitle() {
        return subtitle;
    }

    @SerializedName("rows")
    private java.lang.String[][] rows;

    public void setRows(java.lang.String[][] rows) {
        this.rows = rows;
    }

    public java.lang.String[][] getRows() {
        return rows;
    }

    @SerializedName("headers")
    private HeaderElement[] headers;

    public void setHeaders(HeaderElement[] headers) {
        this.headers = headers;
    }

    public HeaderElement[] getHeaders() {
        return headers;
    }

    @SerializedName("height")
    private java.lang.Integer height;

    public void setHeight(java.lang.Integer height) {
        this.height = height;
    }

    public java.lang.Integer getHeight() {
        return height;
    }

    @SerializedName("title")
    private java.lang.String title;

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getTitle() {
        return title;
    }

    @SerializedName("width")
    private java.lang.Integer width;

    public void setWidth(java.lang.Integer width) {
        this.width = width;
    }

    public java.lang.Integer getWidth() {
        return width;
    }
}
