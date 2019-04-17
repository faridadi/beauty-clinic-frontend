package com.example.dryulia.model;

public class Produk {
    private int id;
    private String nama;
    private int harga;
    private String kode;
    private String des;

    public Produk(){

    }

    public Produk(int id, String nama, int harga, String kode, String des) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.kode = kode;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
