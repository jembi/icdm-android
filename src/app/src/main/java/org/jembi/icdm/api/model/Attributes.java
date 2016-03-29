package org.jembi.icdm.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clive on 29 Mar 2016.
 */
public class Attributes {

    @SerializedName("nSyz3CtsIl7")
    @Expose
    private String DOB;
    @SerializedName("FFfNYb2Y9w0")
    @Expose
    private String FirstName;
    @SerializedName("AGa0LGoYb3N")
    @Expose
    private String Gender;
    @SerializedName("pCaodRm4itY")
    @Expose
    private String LastName;
    @SerializedName("NX7KzuM8gAq")
    @Expose
    private String MobilePhoneNumber;
    @SerializedName("q2StXuwjL63")
    @Expose
    private String NationalIdentityNumber;

    /**
     *
     * @return
     *     The DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     *
     * @param DOB
     *     The DOB
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     *
     * @return
     *     The FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     *
     * @param FirstName
     *     The First Name
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     *
     * @return
     *     The Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     *
     * @param Gender
     *     The Gender
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     *
     * @return
     *     The LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     *
     * @param LastName
     *     The Last Name
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     *
     * @return
     *     The MobilePhoneNumber
     */
    public String getMobilePhoneNumber() {
        return MobilePhoneNumber;
    }

    /**
     *
     * @param MobilePhoneNumber
     *     The Mobile Phone Number
     */
    public void setMobilePhoneNumber(String MobilePhoneNumber) {
        this.MobilePhoneNumber = MobilePhoneNumber;
    }

    /**
     *
     * @return
     *     The NationalIdentityNumber
     */
    public String getNationalIdentityNumber() {
        return NationalIdentityNumber;
    }

    /**
     *
     * @param NationalIdentityNumber
     *     The National Identity Number
     */
    public void setNationalIdentityNumber(String NationalIdentityNumber) {
        this.NationalIdentityNumber = NationalIdentityNumber;
    }
}

