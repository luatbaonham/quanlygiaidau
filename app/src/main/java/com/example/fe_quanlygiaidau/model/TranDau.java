package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TranDau {
    @SerializedName("ma_tran_dau")
    private String maTranDau;

    @SerializedName("ma_giai_dau")
    private String maGiaiDau;

    @SerializedName("ma_doi_1")
    private String maDoi1;

    @SerializedName("ma_doi_2")
    private String maDoi2;

    @SerializedName("ngay_dien_ra")
    private Date ngayDienRa;

    @SerializedName("gio_dien_ra")
    private String gioDienRa;

    @SerializedName("ma_san")
    private String sanVanDong;

    @SerializedName("trang_thai")
    private String trangThai;

    @SerializedName("ma_vong_dau")
    private String maVongDau;

    public TranDau(String maTranDau, String maGiaiDau, String maDoi1, String maDoi2, Date ngayDienRa, String gioDienRa, String sanVanDong, String maVongDau, String trangThai) {
        this.maTranDau = maTranDau;
        this.maGiaiDau = maGiaiDau;
        this.maDoi1 = maDoi1;
        this.maDoi2 = maDoi2;
        this.ngayDienRa = ngayDienRa;
        this.gioDienRa = gioDienRa;
        this.sanVanDong = sanVanDong;
        this.maVongDau = maVongDau;
        this.trangThai = trangThai;
    }

    public String getMaTranDau() {
        return maTranDau;
    }

    public void setMaTranDau(String maTranDau) {
        this.maTranDau = maTranDau;
    }

    public String getMaGiaiDau() {
        return maGiaiDau;
    }

    public void setMaGiaiDau(String maGiaiDau) {
        this.maGiaiDau = maGiaiDau;
    }

    public String getMaDoi1() {
        return maDoi1;
    }

    public void setMaDoi1(String maDoi1) {
        this.maDoi1 = maDoi1;
    }

    public String getMaDoi2() {
        return maDoi2;
    }

    public void setMaDoi2(String maDoi2) {
        this.maDoi2 = maDoi2;
    }

    public Date getNgayDienRa() {
        return ngayDienRa;
    }

    public void setNgayDienRa(Date ngayDienRa) {
        this.ngayDienRa = ngayDienRa;
    }

    public String getGioDienRa() {
        return gioDienRa;
    }

    public void setGioDienRa(String gioDienRa) {
        this.gioDienRa = gioDienRa;
    }

    public String getSanVanDong() {
        return sanVanDong;
    }

    public void setSanVanDong(String sanVanDong) {
        this.sanVanDong = sanVanDong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaVongDau() {
        return maVongDau;
    }

    public void setMaVongDau(String maVongDau) {
        this.maVongDau = maVongDau;
    }

    @Override
    public String toString() {
        return "TranDau{" +
                "maTranDau='" + maTranDau + '\'' +
                ", maGiaiDau='" + maGiaiDau + '\'' +
                ", maDoi1='" + maDoi1 + '\'' +
                ", maDoi2='" + maDoi2 + '\'' +
                ", ngayDienRa=" + ngayDienRa +
                ", gioDienRa=" + gioDienRa +
                ", sanVanDong='" + sanVanDong + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", maVongDau='" + maVongDau + '\'' +
                '}';
    }
}
