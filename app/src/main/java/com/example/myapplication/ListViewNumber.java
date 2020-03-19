package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class ListViewNumber implements Parcelable {
    private int mNumber;

    int getmNumber() {
        return mNumber;
    }

    ListViewNumber(int num) {
        this.mNumber = num;
    }

    private ListViewNumber(Parcel in) {
        mNumber = in.readInt();
    }

    public static final Creator<ListViewNumber> CREATOR = new Creator<ListViewNumber>() {
        @Override
        public ListViewNumber createFromParcel(Parcel in) {
            return new ListViewNumber(in);
        }

        @Override
        public ListViewNumber[] newArray(int size) {
            return new ListViewNumber[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNumber);
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(mNumber);
    }

    boolean isDva() {
    return mNumber % 2 == 0;
}
}