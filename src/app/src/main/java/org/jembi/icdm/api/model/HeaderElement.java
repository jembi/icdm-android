package org.jembi.icdm.api.model;

/**
 * Created by Clive on 23 Mar 2016.
 */
public class HeaderElement {
    @org.codehaus.jackson.annotate.JsonProperty("column")
    private java.lang.String column;

    public void setColumn(java.lang.String column) {
        this.column = column;
    }

    public java.lang.String getColumn() {
        return column;
    }

    @org.codehaus.jackson.annotate.JsonProperty("hidden")
    private java.lang.Boolean hidden;

    public void setHidden(java.lang.Boolean hidden) {
        this.hidden = hidden;
    }

    public java.lang.Boolean getHidden() {
        return hidden;
    }

    @org.codehaus.jackson.annotate.JsonProperty("type")
    private java.lang.String type;

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getType() {
        return type;
    }

    @org.codehaus.jackson.annotate.JsonProperty("meta")
    private java.lang.Boolean meta;

    public void setMeta(java.lang.Boolean meta) {
        this.meta = meta;
    }

    public java.lang.Boolean getMeta() {
        return meta;
    }

    @org.codehaus.jackson.annotate.JsonProperty("name")
    private java.lang.String name;

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getName() {
        return name;
    }
}
