package org.jembi.icdm;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by Clive on 21 Mar 2016.
 */
@Table(name = "Patients")
public class Patient extends Model {

    @Column(name = "FirstName")
    public String mFirstName;

    @Column(name = "LastName")
    public String mLastName;

    @Column(name = "IdNumber")
    public String mIdNumber;

    @Column(name = "DateOfBirth")
    public Date mBirthDate;

    @Column(name = "Gender")
    public String mGender;

    @Column(name = "Mobile")
    public String mMobile;

    @Column(name = "ReferralReason")
    public String mReferralReason;

    @Column(name = "ReferralCaseNumber")
    public String mReferralCaseNumber;

    @Column(name = "ReferralDate")
    public Date mReferralDate;

    @Column(name = "Status")
    public String mStatus;

    public Patient() {
        super();
    }

    public Patient(String firstName, String lastName, String idNumber, Date birthDate, String gender,
                   String mobile, String referralReason, String referralCaseNumber,
                   Date referralDate, String status) {
        super();
        mFirstName = firstName;
        mLastName = lastName;
        mIdNumber = idNumber;
        mBirthDate = birthDate;
        mGender = gender;
        mMobile = mobile;
        mReferralReason = referralReason;
        mReferralCaseNumber = referralCaseNumber;
        mReferralDate = referralDate;
        mStatus = status;
    }
}
