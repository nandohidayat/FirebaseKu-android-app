package com.nandohidayat.app.firebaseku;

import com.google.firebase.database.IgnoreExtraProperties;

public class Barang {
    private String Kdbrg;
    private String Nmbrg;
    private String Satuan;
    private double Hrgbeli;
    private double Hrgjual;
    private int Stok;
    private int Stok_min;

    public Barang() {

    }

    public Barang(String kdbrg, String nmbrg, String satuan, double hrgbeli, double hrgjual, int stok, int stok_min) {
        Kdbrg = kdbrg;
        Nmbrg = nmbrg;
        Satuan = satuan;
        Hrgbeli = hrgbeli;
        Hrgjual = hrgjual;
        Stok = stok;
        Stok_min = stok_min;
    }

    public String getKdbrg() {
        return Kdbrg;
    }

    public String getNmbrg() {
        return Nmbrg;
    }

    public String getSatuan() {
        return Satuan;
    }

    public double getHrgbeli() {
        return Hrgbeli;
    }

    public double getHrgjual() {
        return Hrgjual;
    }

    public int getStok() {
        return Stok;
    }

    public int getStok_min() {
        return Stok_min;
    }
}
