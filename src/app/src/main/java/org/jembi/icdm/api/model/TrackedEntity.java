package org.jembi.icdm.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clive on 29 Mar 2016.
 */
public class TrackedEntity {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("program")
    @Expose
    private String program;
    @SerializedName("programStage")
    @Expose
    private String programStage;
    @SerializedName("trackedEntity")
    @Expose
    private String trackedEntity;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     *
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     *     The program
     */
    public String getProgram() {
        return program;
    }

    /**
     *
     * @param program
     *     The program
     */
    public void setProgram(String program) {
        this.program = program;
    }

    /**
     *
     * @return
     *     The programStage
     */
    public String getProgramStage() {
        return programStage;
    }

    /**
     *
     * @param programStage
     *     The programStage
     */
    public void setProgramStage(String programStage) {
        this.programStage = programStage;
    }

    /**
     *
     * @return
     *     The trackedEntity
     */
    public String getTrackedEntity() {
        return trackedEntity;
    }

    /**
     *
     * @param trackedEntity
     *     The trackedEntity
     */
    public void setTrackedEntity(String trackedEntity) {
        this.trackedEntity = trackedEntity;
    }

    /**
     *
     * @return
     *     The data
     */
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     *     The data
     */
    public void setData(Data data) {
        this.data = data;
    }
}
