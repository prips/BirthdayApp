/*
 * Copyright (c) 2015 PayPal, Inc.
 *
 * All rights reserved.
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 */

package com.droidandme.birthdayapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.HashMap;

/**
 * TODO: Write Javadoc for BirthdaySession.
 *
 * @author pseth
 */
public class BirthdaySession implements Parcelable {

    public enum BirthdayApp {
        FIRST_NAME, LAST_NAME, DOB, MESSAGE;
    }

    private String mFirstName;
    private String mLastName;
    private Date mDOB;
    private String mMessage;

    public BirthdaySession() {}

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public Date getDOB() {
        return mDOB;
    }

    public void setDOB(Date DOB) {
        mDOB = DOB;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        HashMap<Enum, Object> map = new HashMap<Enum, Object>();
        map.put(BirthdayApp.FIRST_NAME, mFirstName);
        map.put(BirthdayApp.LAST_NAME, mLastName);
        map.put(BirthdayApp.DOB, mDOB);
        map.put(BirthdayApp.MESSAGE, mMessage);

        out.writeMap(map);
    }

    /** Static field used to regenerate object, individually or as arrays */
    public static final Parcelable.Creator<BirthdaySession> CREATOR = new Parcelable.Creator<BirthdaySession>() {
        public BirthdaySession createFromParcel(Parcel in) {
            return new BirthdaySession(in);
        }
        public BirthdaySession[] newArray(int size) {
            return new BirthdaySession[size];
        }
    };
    public BirthdaySession(Parcel in) {
        HashMap<Enum, Object> map =  in.readHashMap(this.getClass().getClassLoader());
        mFirstName = map.containsKey(BirthdayApp.FIRST_NAME) ? (String) map.get(BirthdayApp.FIRST_NAME) : null;
        mLastName = map.containsKey(BirthdayApp.LAST_NAME) ? (String) map.get(BirthdayApp.LAST_NAME) : null;
        mDOB = map.containsKey(BirthdayApp.DOB) ? (Date) map.get(BirthdayApp.DOB) : null;
        mMessage = map.containsKey(BirthdayApp.MESSAGE) ? (String) map.get(BirthdayApp.MESSAGE) : null;
    }
}
