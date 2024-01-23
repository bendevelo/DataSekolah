package com.s.insertsekolah.Api.model;

public class sekolah {

   String tipe ;
    String nama ;
    String alamat;
    String pos;
    String provinsi ;
    String kota ;
    String telphone ;
    String email ;
    String facebook ;
    String jumlah;

    public sekolah(String tipe, String nama, String alamat, String pos, String provinsi, String kota, String telphone, String email, String facebook, String jumlah) {
        this.tipe = tipe;
        this.nama = nama;
        this.alamat = alamat;
        this.pos = pos;
        this.provinsi = provinsi;
        this.kota = kota;
        this.telphone = telphone;
        this.email = email;
        this.facebook = facebook;
        this.jumlah = jumlah;
    }

    public String getTipe() {
        return tipe;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getPos() {
        return pos;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getKota() {
        return kota;
    }

    public String getTelphone() {
        return telphone;
    }

    public String getEmail() {
        return email;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getJumlah() {
        return jumlah;
    }
}
