package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class SanVanDong {
    @SerializedName("ma_san")
    private String maSan;
    @SerializedName("ten_san")
    private String ten_san;
    @SerializedName("dia_chi")
    private String diaChi;
    @SerializedName("suc_chua")
    private int sucChua;
    @SerializedName("mo_ta")
    private String moTa;

    public SanVanDong(String maSan, String ten_san, String diaChi, int sucChua, String moTa) {
        this.maSan = maSan;
        this.ten_san = ten_san;
        this.diaChi = diaChi;
        this.sucChua = sucChua;
        this.moTa = moTa;
    }

    public String getMaSan() {
        return maSan;
    }

    public void setMaSan(String maSan) {
        this.maSan = maSan;
    }

    public String getTen_san() {
        return ten_san;
    }

    public void setTen_san(String ten_san) {
        this.ten_san = ten_san;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
