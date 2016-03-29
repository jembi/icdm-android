package org.jembi.icdm.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clive on 29 Mar 2016.
 */
public class DataElements {

    @SerializedName("wzo8RSW6zDr")
    @Expose
    private String CHWIdentificationNumber;
    @SerializedName("w5ZOwFru62D")
    @Expose
    private String ReferralNumber;
    @SerializedName("m6MEw282P1j")
    @Expose
    private String ReferralText;
    @SerializedName("jW0z9BmQF4I")
    @Expose
    private String ReferralDate;
    @SerializedName("TlRQLkwUSTB")
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