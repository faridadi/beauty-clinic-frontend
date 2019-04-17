package com.example.dryulia.model;

public class Voucher {
    private int id;
    private String name;
    private String kode;
    private String des;
    private int type;
    private int value;

    public Voucher() {
    }

    public Voucher(int id, String name, String kode, String des, int type, int value) {
        this.id = id;
        this.name = name;
        this.kode = kode;
        this.des = des;
        this.type = type;
        this.value = value;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
