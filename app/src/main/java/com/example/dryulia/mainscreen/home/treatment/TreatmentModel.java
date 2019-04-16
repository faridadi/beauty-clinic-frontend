package com.example.dryulia.mainscreen.home.treatment;

import android.os.Parcel;
import android.os.Parcelable;

public class TreatmentModel implements Parcelable {
    private String namaTreatment;
    private String detailTreatment;
    private String image_url;
    private int hargaTreatment;
    private int index;

    public String getNamaTreatment() {
        return namaTreatment;
    }

    public void setNamaTreatment(String namaTreatment) {
        this.namaTreatment = namaTreatment;
    }

    public String getDetailTreatment() {
        return detailTreatment;
    }

    public void setDetailTreatment(String detailTreatment) {
        this.detailTreatment = detailTreatment;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getHargaTreatment() {
        return hargaTreatment;
    }

    public void setHargaTreatment(int hargaTreatment) {
        this.hargaTreatment = hargaTreatment;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namaTreatment);
        dest.writeString(this.detailTreatment);
        dest.writeString(this.image_url);
        dest.writeInt(this.hargaTreatment);
        dest.writeInt(this.index);
    }

    public TreatmentModel() {
    }

    protected TreatmentModel(Parcel in) {
        this.namaTreatment = in.readString();
        this.detailTreatment = in.readString();
        this.image_url = in.readString();
        this.hargaTreatment = in.readInt();
        this.index = in.readInt();
    }

    public static final Creator<TreatmentModel> CREATOR = new Creator<TreatmentModel>() {
        @Override
        public TreatmentModel createFromParcel(Parcel source) {
            return new TreatmentModel(source);
        }

        @Override
        public TreatmentModel[] newArray(int size) {
            return new TreatmentModel[size];
        }
    };
}
