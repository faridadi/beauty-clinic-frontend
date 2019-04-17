package com.example.dryulia.model;

public class Medical {
    private int id;
    private String name;
    private int harga;
    private int jumlah;
    private String kode;
    private int type;

    public Medical() {
    }

    public Medical(int id, String name, int harga, int jumlah, String kode, int type) {
        this.id = id;
        this.name = name;
        this.harga = harga;
        this.jumlah = jumlah;
        this.kode = kode;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
