package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class DoiBongGiaiDau {
    @SerializedName("ma_doi_bong")
    private String maDoiBong;
    @SerializedName("ma_giai_dau")
    private String maGiaiDau;
    @SerializedName("ten_doi_bong")
    private String tenDoiBong;
    @SerializedName("logo")
    private String logo;
    @SerializedName("quoc_gia")
    private String quocGia;
    @SerializedName("ma_bang_dau")
    private String mabangDau;
    @SerializedName("hat_giong")
    private String hatGiong;
    @SerializedName("diem_vong_loai")
    private int diemVongLoai;
    @SerializedName("ghi_chu")
    private String ghiChu;

    public DoiBongGiaiDau(String maDoiBong, String maGiaiDau, String tenDoiBong, String logo, String quocGia, String mabangDau, String hatGiong, int diemVongLoai, String ghiChu) {
        this.maDoiBong = maDoiBong;
        this.maGiaiDau = maGiaiDau;
        this.tenDoiBong = tenDoiBong;
        this.logo = logo;
        this.quocGia = quocGia;
        this.mabangDau = mabangDau;
        this.hatGiong = hatGiong;
        this.diemVongLoai = diemVongLoai;
        this.ghiChu = ghiChu;
    }

    public int getDiemVongLoai() {
        return diemVongLoai;
    }

    public void setDiemVongLoai(int diemVongLoai) {
        this.diemVongLoai = diemVongLoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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
