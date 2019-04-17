package com.example.dryulia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dryulia.model.Bill;
import com.example.dryulia.model.Event;
import com.example.dryulia.model.Konsul;
import com.example.dryulia.model.Medical;
import com.example.dryulia.model.Produk;
import com.example.dryulia.model.Treatment;
import com.example.dryulia.model.User;
import com.example.dryulia.model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper
{
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "beauty_clinic.db";
    //constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL("Create table user(id INTEGER PRIMARY KEY,iduser TEXT, nama TEXT, phone TEXT, email TEXT, uname TEXT, authtoken TEXT , token TEXT)");
        db.execSQL("Create table produk(id INTEGER PRIMARY KEY, nama TEXT, harga INTEGER, kode TEXT, des TEXT, img TEXT)");
        //Type 1 = produk, 2 = Treatment, konsul, 3 = voucher
        db.execSQL("Create table bill(id INTEGER PRIMARY KEY, nama TEXT, harga INT, jumlah INT, kode TEXT, type INT)");
        db.execSQL("Create table treatment(id INTEGER PRIMARY KEY, nama TEXT, kode TEXT, harga INT, des TEXT)");
        db.execSQL("Create table event(id INTEGER PRIMARY KEY, nama TEXT, kode TEXT, nama TEXT, des TEXT)");
        //Type 1 = percent, 2 = harga
        db.execSQL("Create table voucher(id INTEGER PRIMARY KEY, nama TEXT, kode TEXT, des TEXT, type INT, percen INTEGER, harga INTEGER)");
        //Type 1 = produk, 2 = Treatment, konsul, 3 = voucher
        db.execSQL("Create table medical(id INTEGER PRIMARY KEY, nama TEXT, harga INT, jumlah INT, kode TEXT, type INT)");
        db.execSQL("Create table konsul(id INTEGER PRIMARY KEY, keluhan TEXT, area INTEGER, lama TEXT, riwayatobat TEXT, riwayatperawatan TEXT, date TEXT, depan TEXT, kiri TEXT, kanan TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS produk");
        db.execSQL("DROP TABLE IF EXISTS bill");
        db.execSQL("DROP TABLE IF EXISTS treatment");
        db.execSQL("DROP TABLE IF EXISTS event");
        db.execSQL("DROP TABLE IF EXISTS voucher");
        db.execSQL("DROP TABLE IF EXISTS medical");
        db.execSQL("DROP TABLE IF EXISTS konsul");
        // create new tables
        onCreate(db);
    }

//==========KONSUL==========
    public boolean insertKonsul(Konsul konsul){
        //check data user ada atau tidak
        if (cekKonsul()){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("keluhan", konsul.getKeluhan());
            values.put("area", konsul.getArea());
            values.put("lama", konsul.getLama());
            values.put("riwayatobat", konsul.getRiwayatobat());
            values.put("riwayatperawatan", konsul.getRiwayatPerawatan());
            values.put("date", konsul.getDate());
            values.put("depan", konsul.getDepan());
            values.put("kiri", konsul.getKiri());
            values.put("kanan", konsul.getKanan());
            // insert row
            long ins = db.insert("konsul", null, values);
            // assigning tags to todo
            if (ins == -1 ){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }
//cek data konsul
    public boolean cekKonsul(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM konsul";
        Cursor c = db.rawQuery(query,null);
        if (c != null && c.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }

    public Konsul getKonsul(){
        SQLiteDatabase db = this.getReadableDatabase();
        try{
            String selectQuery = "SELECT * FROM konsul";
            Cursor cursor = db.rawQuery(selectQuery, null);
            if(cursor.getCount() > 0) {
                Konsul data = new Konsul();
                data.setId              (cursor.getInt(cursor.getColumnIndex("id")));
                data.setKeluhan         (cursor.getString(cursor.getColumnIndex("keluhan")));
                data.setArea            (cursor.getString(cursor.getColumnIndex("area")));
                data.setLama            (cursor.getString(cursor.getColumnIndex("lama")));
                data.setRiwayatobat     (cursor.getString(cursor.getColumnIndex("riwayatobat")));
                data.setRiwayatPerawatan(cursor.getString(cursor.getColumnIndex("riwayatperawatan")));
                data.setDate            (cursor.getString(cursor.getColumnIndex("date")));
                data.setDepan           (cursor.getString(cursor.getColumnIndex("depan")));
                data.setKiri            (cursor.getString(cursor.getColumnIndex("kiri")));
                data.setKanan           (cursor.getString(cursor.getColumnIndex("kanan")));
                return data;
            }else {
                return null;
            }
        }finally {
            db.close();
        }
    }
    //delete konsul
    public boolean deleteAllKonsul(){
        SQLiteDatabase db = this.getReadableDatabase();
        int num = db.delete("konsul", "1", null);
        if (num > 0){
            return true;
        }else {
            return false;
        }
    }



//===========USER============
    public boolean insertUser(User user){
        //check data user ada atau tidak
        if (cekUser()){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("iduser", user.getIdUser());
            values.put("nama", user.getNama());
            values.put("phone", user.getPhone());
            values.put("email", user.getEmail());
            values.put("uname", user.getUname());
            values.put("authtoken", user.getAuthtoken());
            values.put("token", user.getToken());
            // insert row
            long ins = db.insert("user", null, values);
            // assigning tags to todo
            if (ins == -1 ){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }
    //mengecek data user apakah sudah ada didalam database
    public boolean cekUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM user";
        Cursor c = db.rawQuery(query,null);
        if (c != null && c.getCount() > 0){
            return true;
        }else {
            //jika data user tidak ada maka akan mmembuat user baru dengan password default "admin"
            return false;
        }
    }


    //Produk
    public boolean insertProduk(Produk produk){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", produk.getNama());
        values.put("harga", produk.getNama());
        values.put("kode", produk.getKode());
        values.put("des", produk.getDes());;

        // insert row
        long ins = db.insert("produk", null, values);
        // assigning tags to todo
        if (ins == -1 ){
            return false;
        }else {
            return true;
        }
    }


    public boolean insertTreatment(Treatment treatment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", treatment.getNama());
        values.put("harga", treatment.getHarga());
        values.put("kode", treatment.getKode());
        values.put("des", treatment.getDes());;

        // insert row
        long ins = db.insert("treatment", null, values);
        // assigning tags to todo
        if (ins == -1 ){
            return false;
        }else {
            return true;
        }
    }

}
