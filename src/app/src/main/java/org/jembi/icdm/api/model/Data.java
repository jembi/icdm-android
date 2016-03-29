package org.jembi.icdm.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Clive on 29 Mar 2016.
 */

public class Data {

    @SerializedName("parameters")
    @Expose
    private Parameters parameters;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("dataElements")
    @Expose
    private DataElements dataElements;

    /**
     *
     * @return
     *     The parameters
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     *
     * @param parameters
     *     The parameters
     */
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    /**
     *
     * @return
     *     The attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     *
     * @param attributes
     *     The attributes
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     *
     * @return
     *     The dataElements
     */
    public DataElements getDataElements() {
        return dataElements;
    }

    /**
     *
     * @param dataElements
     *     The dataElements
     */
    public void setDataElements(DataElements dataElements) {
        this.dataElements = dataElements;
    }
}


