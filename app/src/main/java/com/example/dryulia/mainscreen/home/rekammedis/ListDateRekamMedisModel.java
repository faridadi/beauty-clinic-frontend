package com.example.dryulia.mainscreen.home.rekammedis;

import android.os.Parcel;
import android.os.Parcelable;

public class ListDateRekamMedisModel implements Parcelable {
    private String tanggal;

    public ListDateRekamMedisModel(String tanggal) {
        this.tanggal = tanggal;
    }

    public ListDateRekamMedisModel() {

    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tanggal);
    }

    protected ListDateRekamMedisModel(Parcel in) {
        this.tanggal = in.readString();

    }

    public static final Parcelable.Creator<ListDateRekamMedisModel> CREATOR = new Parcelable.Creator<ListDateRekamMedisModel>() {
        @Override
        public ListDateRekamMedisModel createFromParcel(Parcel source) {
            return new ListDateRekamMedisModel(source);
        }

        @Override
        public ListDateRekamMedisModel[] newArray(int size) {
            return new ListDateRekamMedisModel[size];
        }
    };
}
