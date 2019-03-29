package com.example.module_2.activity.logic;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelebleCat implements Parcelable {

    public String s;
    public int i;

//    public ParcelebleCat(String s, int i) {
//        this.s = s;
//        this.i = i;
//    }

    public ParcelebleCat(Parcel in) {
        s = in.readString();
        i = in.readInt();
    }

    public static final Creator<ParcelebleCat> CREATOR = new Creator<ParcelebleCat>() {
        @Override
        public ParcelebleCat createFromParcel(Parcel in) {
            return new ParcelebleCat(in);
        }

        @Override
        public ParcelebleCat[] newArray(int size) {
            return new ParcelebleCat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeString(s);
    parcel.writeInt(i);
    }


}
