package org.jembi.icdm.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clive on 29 Mar 2016.
 */

public class Parameters {

    @SerializedName("orgUnit")
    @Expose
    private String orgUnit;
    @SerializedName("eventOrgUnit")
    @Expose
    private String eventOrgUnit;
    @SerializedName("programDate")
    @Expose
    private String programDate;
    @SerializedName("eventDate")
    @Expose
    private String eventDate;

    /**
     *
     * @return
     *     The orgUnit
     */
    public String getOrgUnit() {
        return orgUnit;
    }

    /**
     *
     * @param orgUnit
     *     The orgUnit
     */
    public void setOrgUnit(String orgUnit) {
        this.orgUnit = orgUnit;
    }

    /**
     *
     * @return
     *     The eventOrgUnit
     */
    public String getEventOrgUnit() {
        return eventOrgUnit;
    }

    /**
     *
     * @param eventOrgUnit
     *     The eventOrgUnit
     */
    public void setEventOrgUnit(String eventOrgUnit) { this.eventOrgUnit = eventOrgUnit; }

    /**
     *
     * @return
     *     The programDate
     */
    public String getProgramDate() {
        return programDate;
    }

    /**
     *
     * @param programDate
     *     The programDate
     */
    public void setProgramDate(String programDate) {
        this.programDate = programDate;
    }

    /**
     *
     * @return
     *     The eventDate
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     *
     * @param eventDate
     *     The eventDate
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}

