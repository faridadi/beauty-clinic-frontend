package com.example.dryulia.mainscreen.home.produk;

import android.os.Parcel;
import android.os.Parcelable;

public class ProdukModel implements Parcelable {
        private String namaProduk;
        private String detailProduk;
        private String image_url;
        private int hargaProduk;
        private int jumlahOrder;
        private int index;

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getDetailProduk() {
        return detailProduk;
    }

    public void setDetailProduk(String detailProduk) {
        this.detailProduk = detailProduk;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(int hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public int getJumlahOrder() {
        return jumlahOrder;
    }

    public void setJumlahOrder(int jumlahOrder) {
        this.jumlahOrder = jumlahOrder;
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
        dest.writeString(this.namaProduk);
        dest.writeString(this.detailProduk);
        dest.writeString(this.image_url);
        dest.writeInt(this.hargaProduk);
        dest.writeInt(this.jumlahOrder);
        dest.writeInt(this.index);
    }

    public ProdukModel() {
    }

    protected ProdukModel(Parcel in) {
        this.namaProduk = in.readString();
        this.detailProduk = in.readString();
        this.image_url = in.readString();
        this.hargaProduk = in.readInt();
        this.jumlahOrder = in.readInt();
        this.index = in.readInt();
    }

    public static final Parcelable.Creator<ProdukModel> CREATOR = new Parcelable.Creator<ProdukModel>() {
        @Override
        public ProdukModel createFromParcel(Parcel source) {
            return new ProdukModel(source);
        }

        @Override
        public ProdukModel[] newArray(int size) {
            return new ProdukModel[size];
        }
    };

    public ProdukModel(String namaProduk, String detailProduk, String image_url, int hargaProduk, int jumlahOrder) {
        this.namaProduk = namaProduk;
        this.detailProduk = detailProduk;
        this.image_url = image_url;
        this.hargaProduk = hargaProduk;
        this.jumlahOrder = jumlahOrder;
    }
}
