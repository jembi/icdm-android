package org.jembi.icdm.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clive on 29 Mar 2016.
 */
public class DataElements {

    @SerializedName("CHW Identification Number")
    @Expose
    private String CHWIdentificationNumber;
    @SerializedName("Referral Number")
    @Expose
    private String ReferralNumber;
    @SerializedName("Referral Text")
    @Expose
    private String ReferralText;
    @SerializedName("Referral Date")
    @Expose
    private String ReferralDate;
    @SerializedName("CHW Name")
    @Expose
    private String CHWName;

    /**
     *
     * @return
     *     The CHWIdentificationNumber
     */
    public String getCHWIdentificationNumber() {
        return CHWIdentificationNumber;
    }

    /**
     *
     * @param CHWIdentificationNumber
     *     The CHW Identification Number
     */
    public void setCHWIdentificationNumber(String CHWIdentificationNumber) {
        this.CHWIdentificationNumber = CHWIdentificationNumber;
    }

    /**
     *
     * @return
     *     The ReferralNumber
     */
    public String getReferralNumber() {
        return ReferralNumber;
    }

    /**
     *
     * @param ReferralNumber
     *     The Referral Number
     */
    public void setReferralNumber(String ReferralNumber) {
        this.ReferralNumber = ReferralNumber;
    }

    /**
     *
     * @return
     *     The ReferralText
     */
    public String getReferralText() {
        return ReferralText;
    }

    /**
     *
     * @param ReferralText
     *     The Referral Text
     */
    public void setReferralText(String ReferralText) {
        this.ReferralText = ReferralText;
    }

    /**
     *
     * @return
     *     The ReferralDate
     */
    public String getReferralDate() {
        return ReferralDate;
    }

    /**
     *
     * @param ReferralDate
     *     The Referral Date
     */
    public void setReferralDate(String ReferralDate) {
        this.ReferralDate = ReferralDate;
    }

    /**
     *
     * @return
     *     The CHWName
     */
    public String getCHWName() {
        return CHWName;
    }

    /**
     *
     * @param CHWName
     *     The CHW Name
     */
    public void setCHWName(String CHWName) {
        this.CHWName = CHWName;
    }
}