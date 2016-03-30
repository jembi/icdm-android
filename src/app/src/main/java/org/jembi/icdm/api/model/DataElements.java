package org.jembi.icdm.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clive on 29 Mar 2016.
 */
public class DataElements {

    @SerializedName("Rm3lzLu02af")
    @Expose
    private String CHWIdentificationNumber;
    @SerializedName("nzVAFY5TRNk")
    @Expose
    private String ReferralNumber;
    @SerializedName("NgPeQyMBoEY")
    @Expose
    private String ReferralText;
    @SerializedName("iYIbwy9q8N9")
    @Expose
    private String ReferralDate;
    @SerializedName("NebejeHH2UJ")
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