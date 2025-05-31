package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Giaidau implements Serializable {
    @SerializedName("ma_giai_dau")
    private String maGiaidau;
    @SerializedName("ten_giai_dau")
    private String tenGiaiDau;
    @SerializedName("mo_ta")
    private String moTa;
    @SerializedName("ngay_bat_dau")
    private Date ngayBatdau;
    @SerializedName("ngay_ket_thuc")
    private Date ngayKetThuc;

    @SerializedName("ngay_ket_thuc_dang_ky_giai")
    private Date ngayKetThucDangKy;
    @SerializedName("gioi_tinh")
    private String gioiTinh;
    @SerializedName("ten_to_chuc")
    private String tenToChuc;

    @SerializedName("hinh-anh")
    private String hinhAnh;

    public Giaidau(String maGiaidau, String tenGiaiDau, String moTa, Date ngayBatdau, Date ngayKetThuc, Date ngayKetThucDangKy, String gioiTinh, String tenToChuc, String hinhAnh) {
        this.maGiaidau = maGiaidau;
        this.tenGiaiDau = tenGiaiDau;
        this.moTa = moTa;
        this.ngayBatdau = ngayBatdau;
        this.ngayKetThuc = ngayKetThuc;
        this.ngayKetThucDangKy = ngayKetThucDangKy;
        this.gioiTinh = gioiTinh;
        this.tenToChuc = tenToChuc;
        this.hinhAnh = hinhAnh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Date getNgayKetThucDangKy() {
        return ngayKetThucDangKy;
    }

    public void setNgayKetThucDangKy(Date ngayKetThucDangKy) {
        this.ngayKetThucDangKy = ngayKetThucDangKy;
    }

    public String getMaGiaidau() {
        return maGiaidau;
    }

    public void setMaGiaidau(String maGiaidau) {
        this.maGiaidau = maGiaidau;
    }

    public String getTenGiaiDau() {
        return tenGiaiDau;
    }

    public void setTenGiaiDau(String tenGiaiDau) {
        this.tenGiaiDau = tenGiaiDau;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Date getNgayBatdau() {
        return ngayBatdau;
    }

    public void setNgayBatdau(Date ngayBatdau) {
        this.ngayBatdau = ngayBatdau;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTenToChuc() {
        return tenToChuc;
    }

    public void setTenToChuc(String tenToChuc) {
        this.tenToChuc = tenToChuc;
    }

    @Override
    public String toString() {
        return "Giaidau{" +
                "maGiaidau='" + maGiaidau + '\'' +
                ", tenGiaiDau='" + tenGiaiDau + '\'' +
                ", moTa='" + moTa + '\'' +
                ", ngayBatdau=" + ngayBatdau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", ngayKetThucDangKy=" + ngayKetThucDangKy +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", tenToChuc='" + tenToChuc + '\'' +
                '}';
    }
}
