package com.example.dryulia.model;

public class Konsul {
    private int id;
    private String keluhan;
    private String area;
    private String lama;
    private String riwayatobat;
    private String riwayatPerawatan;
    private String date;
    private String depan;
    private String kiri;
    private String kanan;

    public Konsul() {
    }

    public Konsul(int id, String keluhan, String area, String lama, String riwayatobat, String riwayatPerawatan, String date, String depan, String kiri, String kanan) {
        this.id = id;
        this.keluhan = keluhan;
        this.area = area;
        this.lama = lama;
        this.riwayatobat = riwayatobat;
        this.riwayatPerawatan = riwayatPerawatan;
        this.date = date;
        this.depan = depan;
        this.kiri = kiri;
        this.kanan = kanan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLama() {
        return lama;
    }

    public void setLama(String lama) {
        this.lama = lama;
    }

    public String getRiwayatobat() {
        return riwayatobat;
    }

    public void setRiwayatobat(String riwayatobat) {
        this.riwayatobat = riwayatobat;
    }

    public String getRiwayatPerawatan() {
        return riwayatPerawatan;
    }

    public void setRiwayatPerawatan(String riwayatPerawatan) {
        this.riwayatPerawatan = riwayatPerawatan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepan() {
        return depan;
    }

    public void setDepan(String depan) {
        this.depan = depan;
    }

    public String getKiri() {
        return kiri;
    }

    public void setKiri(String kiri) {
        this.kiri = kiri;
    }

    public String getKanan() {
        return kanan;
    }

    public void setKanan(String kanan) {
        this.kanan = kanan;
    }
}
