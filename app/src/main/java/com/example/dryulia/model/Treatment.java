package com.example.dryulia.model;

public class Treatment {
    private int id;
    private String nama;
    private String kode;
    private int harga;
    private String des;

    public Treatment() {
    }

    public Treatment(int id, String nama, String kode, int harga, String des) {
        this.id = id;
        this.nama = nama;
        this.kode = kode;
        this.harga = harga;
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

    public void setNama(String name) {
        this.nama = name;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}


