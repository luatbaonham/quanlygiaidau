package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CauThu {
    @SerializedName("ma_cau_thu")
    private String maCauThu;

    @SerializedName("ho_ten")
    private String hoTen;

    @SerializedName("ngay_sinh")
    private Date ngaySinh;

    @SerializedName("so_ao")
    private int soAo;

    @SerializedName("gioi_tinh")
    private String gioiTinh;

    @SerializedName("ma_vi_tri")
    private String maViTri;

    @SerializedName("ma_doi_bong")
    private String maDoiBong;

    @SerializedName("hinh_anh")
    private String hinhAnh;

    public CauThu(String maCauThu, String hoTen, Date ngaySinh, int soAo, String gioiTinh, String maDoiBong, String maViTri, String hinhAnh) {
        this.maCauThu = maCauThu;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soAo = soAo;
        this.gioiTinh = gioiTinh;
        this.maDoiBong = maDoiBong;
        this.maViTri = maViTri;
        this.hinhAnh = hinhAnh;
    }

    public int getSoAo() {
        return soAo;
    }

    public void setSoAo(int soAo) {
        this.soAo = soAo;
    }

    public String getMaCauThu() {
        return maCauThu;
    }

    public void setMaCauThu(String maCauThu) {
        this.maCauThu = maCauThu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getMaDoiBong() {
        return maDoiBong;
    }

    public void setMaDoiBong(String maDoiBong) {
        this.maDoiBong = maDoiBong;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
