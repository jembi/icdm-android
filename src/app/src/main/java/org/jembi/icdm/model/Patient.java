package org.jembi.icdm.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by Clive on 21 Mar 2016.
 */
@Table(name = "Patients")
public class Patient extends Model {

    @Column(name = "TrackedEntityInstanceId")
    public String mTrackedEntityInstanceId;

    @Column(name = "TeuId")
    public String mTeuId;

    @Column(name = "IdNumber")
    public String mNId;

    @Column(name = "FirstName")
    public String mFirstName;

    @Column(name = "LastName")
    public String mLastName;

    @Column(name = "DateOfBirth")
    public Date mDob;

    @Column(name = "Gender")
    public String mGender;

    @Column(name = "Mobile")
    public String mFon;

    @Column(name = "PharmStatus")
    public String mPharmStatus;

    @Column(name = "PharmId")
    public String mPharmId;

    @Column(name = "PharmName")
    public String mPharmName;

    @Column(name = "ConfirmationStatus")
    public String mConfirmationStatus;

    @Column(name = "MedPuInterval")
    public String mMedPuInterval;

    @Column(name = "NurseName")
    public String mNurseName;

    @Column(name = "NurseId")
    public String mNurseId;

    @Column(name = "Med1")
    public String mMed1;

    @Column(name = "Med2")
    public String mMed2;

    @Column(name = "Med3")
    public String mMed3;

    @Column(name = "Diagnosis")
    public String mDiagnosis;

    @Column(name = "ConfComment")
    public String mConfComment;

    @Column(name = "ReferralReason")
    public String mReferralReason;

    @Column(name = "ChwStatus")
    public String mChwStatus;

    @Column(name = "ChwName")
    public String mChwName;

    @Column(name = "ReferralDate")
    public Date mReferralDate;

    @Column(name = "ReferralNumber")
    public String mReferralNumber;

    @Column(name = "ChwId")
    public String mChwId;

    @Column(name = "NurseEventUid")
    public String mNurseEventUid;

    @Column(name = "ChwEventUid")
    public String mChwEventUid;

    @Column(name = "PharmEventUid")
    public String mPharmEventUid;

    @Column(name = "ChwxDate")
    public Date mChwxDate;

    @Column(name = "ConfxDate")
    public Date mConfxDate;

    @Column(name = "PharmxDate")
    public Date mPharmxDate;

    @Column(name = "ChwDueDate")
    public Date mChwDueDate;

    @Column(name = "ConfDueDate")
    public Date mConfDueDate;

    @Column(name = "PharmDueDate")
    public Date mPharmDueDate;

    public Patient() {
        super();
    }
}
