package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TrongTai {
    @SerializedName("ma_trong_tai")
    private String maTrongTai;

    @SerializedName("ho_ten")
    private String hoTen;

    @SerializedName("ngay_sinh")
    private Date ngaySinh;

    @SerializedName("gioi_tinh")
    private String gioiTinh;

    @SerializedName("hinh_anh")
    private String hinhAnh;

    public TrongTai(String maTrongTai, String hoTen, Date ngaySinh, String hinhAnh, String gioiTinh) {
        this.maTrongTai = maTrongTai;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.hinhAnh = hinhAnh;
        this.gioiTinh = gioiTinh;
    }

    public String getMaTrongTai() {
        return maTrongTai;
    }

    public void setMaTrongTai(String maTrongTai) {
        this.maTrongTai = maTrongTai;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
