package com.example.dhktpm15a_nhom16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataNhanVien extends SQLiteOpenHelper {
    public DataNhanVien(@Nullable Context context,
                        @Nullable String name,
                        @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE nhanvien (id INTEGER PRIMARY KEY autoincrement, name TEXT NOT NULL, " +
                "positon TEXT NOT NULL, age INTERGER, country TEXT NOT NULL )";

        db.execSQL(sql);
    }
    public void addNhanVien(NhanVien nhanVien){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("name",nhanVien.getName());
        values.put("position",nhanVien.getAge());
        values.put("age",nhanVien.getAge());
        values.put("country",nhanVien.getAge());


        db.insert("nhanvien",null, values);

    }
    public int removeNhanVien(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete("user","id = ?", new String[]{String.valueOf(id)});
    }

    public List<NhanVien> getAll(){

        List<NhanVien> nhanVienList = new ArrayList<>();
        String sql = "select * from nhanvien";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do{
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(cursor.getInt(0));
                nhanVien.setName(cursor.getString(1));
                nhanVien.setPosition(cursor.getString(2));
                nhanVien.setAge(cursor.getInt(3));
                nhanVien.setCountry(cursor.getString(4));

                nhanVienList.add(nhanVien);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return nhanVienList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}






