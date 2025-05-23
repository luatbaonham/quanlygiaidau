package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class BangXepHangVongLoai {
    @SerializedName("ma_doi_bong")
    private String maDoiBong;

    @SerializedName("ma_bang_dau")
    private String maBangDau;

    @SerializedName("diem")
    private int diem;

    public BangXepHangVongLoai(String maDoiBong, String maBangDau, int diem) {
        this.maDoiBong = maDoiBong;
        this.maBangDau = maBangDau;
        this.diem = diem;
    }

    public String getMaDoiBong() {
        return maDoiBong;
    }

    public void setMaDoiBong(String maDoiBong) {
        this.maDoiBong = maDoiBong;
    }

    public String getMaBangDau() {
        return maBangDau;
    }

    public void setMaBangDau(String maBangDau) {
        this.maBangDau = maBangDau;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
