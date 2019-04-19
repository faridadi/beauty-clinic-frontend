package com.example.dryulia.model;

public class User {
    private int id;
    private String idUser;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String uname;
    private String token_acc;
    private String token_gcm;

    public User(int id, String idUser, String name, String phone, String email,String address, String uname, String token_acc, String token_gcm) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.uname = uname;
        this.token_acc = token_acc;
        this.token_gcm = token_gcm;
    }
    public  User(){

    }

    public User(String idUser, String name, String phone, String email, String address, String uname, String token_acc, String token_gcm) {
        this.idUser = idUser;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.uname = uname;
        this.token_acc = token_acc;
        this.token_gcm = token_gcm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String nama) {
        this.name = nama;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getToken_acc() {
        return token_acc;
    }

    public void setToken_acc(String token_acc) {
        this.token_acc = token_acc;
    }

    public String getToken_gcm() {
        return token_gcm;
    }

    public void setToken_gcm(String token_gcm) {
        this.token_gcm = token_gcm;
    }
}
