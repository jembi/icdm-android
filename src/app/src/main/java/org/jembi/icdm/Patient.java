package org.jembi.icdm;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

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
    public int mBirthDate;

    @Column(name = "Gender")
    public String mGender;

    @Column(name = "Mobile")
    public String mMobile;

    @Column(name = "ReferralReason")
    public String mReferralReason;

    public Patient() {
        super();
    }

    public Patient(String firstName, String lastName, String idNumber, int birthDate, String gender,
                   String mobile, String referralReason) {
        super();
        mFirstName = firstName;
        mLastName = lastName;
        mIdNumber = idNumber;
        mBirthDate = birthDate;
        mGender = gender;
        mMobile = mobile;
        mReferralReason = referralReason;
    }
}
