package org.jembi.icdm.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Clive on 23 Mar 2016.
 */
public class HeaderElement {
    @SerializedName("column")
    private java.lang.String column;

    public void setColumn(java.lang.String column) {
        this.column = column;
    }

    public java.lang.String getColumn() {
        return column;
    }

    @SerializedName("hidden")
    private java.lang.Boolean hidden;

    public void setHidden(java.lang.Boolean hidden) {
        this.hidden = hidden;
    }

    public java.lang.Boolean getHidden() {
        return hidden;
    }

    @SerializedName("type")
    private java.lang.String type;

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getType() {
        return type;
    }

    @SerializedName("meta")
    private java.lang.Boolean meta;

    public void setMeta(java.lang.Boolean meta) {
        this.meta = meta;
    }

    public java.lang.Boolean getMeta() {
        return meta;
    }

    @SerializedName("name")
    private java.lang.String name;

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getName() {
        return name;
    }
}
