package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class DoiBongGiaiDau {
    @SerializedName("ma_doi_bong ")
    private String maDoiBong;
    @SerializedName("ma_giai_dau ")
    private String maGiaiDau;
    @SerializedName("ten_doi_bong")
    private String tenDoiBong;
    @SerializedName("logo")
    private String logo;
    @SerializedName("quoc_gia")
    private String quocGia;
    @SerializedName("ma_bang_dau ")
    private String mabangDau;
    @SerializedName("hat_giong")
    private String hatGiong;

    public DoiBongGiaiDau(String maDoiBong, String maGiaiDau, String tenDoiBong, String logo, String mabangDau, String quocGia, String hatGiong) {
        this.maDoiBong = maDoiBong;
        this.maGiaiDau = maGiaiDau;
        this.tenDoiBong = tenDoiBong;
        this.logo = logo;
        this.mabangDau = mabangDau;
        this.quocGia = quocGia;
        this.hatGiong = hatGiong;
    }

    public String getMaDoiBong() {
        return maDoiBong;
    }

    public void setMaDoiBong(String maDoiBong) {
        this.maDoiBong = maDoiBong;
    }

    public String getTenDoiBong() {
        return tenDoiBong;
    }

    public void setTenDoiBong(String tenDoiBong) {
        this.tenDoiBong = tenDoiBong;
    }

    public String getMaGiaiDau() {
        return maGiaiDau;
    }

    public void setMaGiaiDau(String maGiaiDau) {
        this.maGiaiDau = maGiaiDau;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMabangDau() {
        return mabangDau;
    }

    public void setMabangDau(String mabangDau) {
        this.mabangDau = mabangDau;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getHatGiong() {
        return hatGiong;
    }

    public void setHatGiong(String hatGiong) {
        this.hatGiong = hatGiong;
    }
}
