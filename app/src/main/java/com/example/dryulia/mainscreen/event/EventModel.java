package com.example.dryulia.mainscreen.event;

import android.os.Parcel;
import android.os.Parcelable;

public class EventModel implements Parcelable {
    private String namaEvent;
    private String image_url;
    private String detailEvent;
    private int index;

    public EventModel() {

    }


    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDetailEvent() {
        return detailEvent;
    }

    public void setDetailEvent(String detailEvent) {
        this.detailEvent = detailEvent;
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
        dest.writeString(namaEvent);
        dest.writeString(image_url);
        dest.writeString(detailEvent);
        dest.writeInt(index);
    }

    protected EventModel(Parcel in) {
        namaEvent = in.readString();
        image_url = in.readString();
        detailEvent = in.readString();
        index = in.readInt();
    }

    public static final Creator<EventModel> CREATOR = new Creator<EventModel>() {
        @Override
        public EventModel createFromParcel(Parcel in) {
            return new EventModel(in);
        }

        @Override
        public EventModel[] newArray(int size) {
            return new EventModel[size];
        }
    };
}
