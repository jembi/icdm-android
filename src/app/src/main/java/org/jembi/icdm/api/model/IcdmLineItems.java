package org.jembi.icdm.api.model;

import org.jembi.icdm.api.model.HeaderElement;

/**
 * Created by Clive on 23 Mar 2016.
 */
public final class IcdmLineItems {
    @org.codehaus.jackson.annotate.JsonProperty("subtitle")
    private java.lang.String subtitle;

    public void setSubtitle(java.lang.String subtitle) {
        this.subtitle = subtitle;
    }

    public java.lang.String getSubtitle() {
        return subtitle;
    }

    @org.codehaus.jackson.annotate.JsonProperty("rows")
    private java.lang.String[][] rows;

    public void setRows(java.lang.String[][] rows) {
        this.rows = rows;
    }

    public java.lang.String[][] getRows() {
        return rows;
    }

    @org.codehaus.jackson.annotate.JsonProperty("headers")
    private HeaderElement[] headers;

    public void setHeaders(HeaderElement[] headers) {
        this.headers = headers;
    }

    public HeaderElement[] getHeaders() {
        return headers;
    }

    @org.codehaus.jackson.annotate.JsonProperty("height")
    private java.lang.Integer height;

    public void setHeight(java.lang.Integer height) {
        this.height = height;
    }

    public java.lang.Integer getHeight() {
        return height;
    }

    @org.codehaus.jackson.annotate.JsonProperty("title")
    private java.lang.String title;

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getTitle() {
        return title;
    }

    @org.codehaus.jackson.annotate.JsonProperty("width")
    private java.lang.Integer width;

    public void setWidth(java.lang.Integer width) {
        this.width = width;
    }

    public java.lang.Integer getWidth() {
        return width;
    }
}
