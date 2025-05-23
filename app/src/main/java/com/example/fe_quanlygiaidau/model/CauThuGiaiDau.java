package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class CauThuGiaiDau {
    @SerializedName("ma_cau_thu")
    private String maCauThu;

    @SerializedName("ma_doi_bong")
    private String maDoiBong;

    @SerializedName("ma_giai_dau")
    private String maGiaiDau;

    @SerializedName("ho_ten")
    private String hoTen;

    @SerializedName("so_ao")
    private int soAo;

    @SerializedName("hinh_anh")
    private String hinhAnh;

    @SerializedName("ma_vi_tri")
    private String maViTri;

    public CauThuGiaiDau(String maCauThu, String maDoiBong, String hoTen, String maGiaiDau, int soAo, String hinhAnh, String maViTri) {
        this.maCauThu = maCauThu;
        this.maDoiBong = maDoiBong;
        this.hoTen = hoTen;
        this.maGiaiDau = maGiaiDau;
        this.soAo = soAo;
        this.hinhAnh = hinhAnh;
        this.maViTri = maViTri;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSoAo() {
        return soAo;
    }

    public void setSoAo(int soAo) {
        this.soAo = soAo;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getMaCauThu() {
        return maCauThu;
    }

    public void setMaCauThu(String maCauThu) {
        this.maCauThu = maCauThu;
    }

    public String getMaDoiBong() {
        return maDoiBong;
    }

    public void setMaDoiBong(String maDoiBong) {
        this.maDoiBong = maDoiBong;
    }

    public String getMaGiaiDau() {
        return maGiaiDau;
    }

    public void setMaGiaiDau(String maGiaiDau) {
        this.maGiaiDau = maGiaiDau;
    }
}
