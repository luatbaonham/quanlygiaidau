package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class DoiBong {
    @SerializedName("ma_doi_bong")
    private String maDoiBong;

    @SerializedName("ten_doi_bong")
    private String tenDoiBong;

    @SerializedName("quoc_gia")
    private String quocGia;

    @SerializedName("gioi_tinh")
    private String gioiTinh;

    @SerializedName("logo")
    private String logo;

    @SerializedName("ma_ql_doi_bong")
    private String maQLDoiBong;

    public DoiBong(String maDoiBong, String tenDoiBong, String quocGia, String gioiTinh, String logo, String maQLDoiBong) {
        this.maDoiBong = maDoiBong;
        this.tenDoiBong = tenDoiBong;
        this.quocGia = quocGia;
        this.gioiTinh = gioiTinh;
        this.logo = logo;
        this.maQLDoiBong = maQLDoiBong;
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

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaQLDoiBong() {
        return maQLDoiBong;
    }

    public void setMaQLDoiBong(String maQLDoiBong) {
        this.maQLDoiBong = maQLDoiBong;
    }
}
