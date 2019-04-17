package com.example.dryulia.model;

public class Event {
    private int id;
    private String nam;
    private String kode;
    private String nama;
    private String des;

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Event(int id, String nam, String kode, String nama, String des) {
        this.id = id;
        this.nam = nam;
        this.kode = kode;
        this.nama = nama;
        this.des = des;
    }
}
