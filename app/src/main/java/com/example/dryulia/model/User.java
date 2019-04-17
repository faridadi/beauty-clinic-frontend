package com.example.dryulia.model;

public class User {
    private int id;
    private String idUser;
    private String nama;
    private String phone;
    private String email;
    private String uname;
    private String authtoken;
    private String token;

    public User(int id, String idUser, String nama, String phone, String email, String uname, String authtoken, String token) {
        this.id = id;
        this.idUser = idUser;
        this.nama = nama;
        this.phone = phone;
        this.email = email;
        this.uname = uname;
        this.authtoken = authtoken;
        this.token = token;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
