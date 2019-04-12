package com.example.dryulia.mainscreen.home.produk;

public class ProdukModel {
        private String namaProduk;
        private String detailProduk;
        private int hargaProduk;
        private int id;
        private String image_url;
        private int jumlahOrder;

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

    public int getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(int hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getJumlahOrder() {
        return jumlahOrder;
    }

    public void setJumlahOrder(int jumlahOrder) {
        this.jumlahOrder = jumlahOrder;
    }
}
