package com.example.dhktpm15a_nhom16;

public class NhanVien {
    private int id;
    private String name;
    private int age;
    private int imgNV;

    public NhanVien() {
    }

    public NhanVien(String name, int age, int imgNV) {
        this.name = name;
        this.age = age;
        this.imgNV = imgNV;
    }

    public NhanVien(int id, String name, int age, int imgNV) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.imgNV = imgNV;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImgNV() {
        return imgNV;
    }

    public void setImgNV(int imgNV) {
        this.imgNV = imgNV;
    }


}
