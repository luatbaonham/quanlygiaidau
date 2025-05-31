package com.example.fe_quanlygiaidau.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Item_hienthi_KQ {
    @SerializedName("ten_doi_bong")
    private String tenDoi1, tenDoi2;
    @SerializedName("logo")
    private String logoDoi1, logoDoi2;
    @SerializedName("ten_giai_dau")
    private String tengiaidau;
    @SerializedName("so_ban_doi_1")
    private int soBanDoi1;

    @SerializedName("so_ban_doi_2")
    private int soBanDoi2;
    @SerializedName("ngay_dien_ra")
    private Date ngayDienRa;

    @SerializedName("gio_dien_ra")
    private String gioDienRa;

    public Item_hienthi_KQ(String tenDoi1, String tenDoi2, String logoDoi1, String logoDoi2,String tengiaidau, int soBanDoi1, int soBanDoi2, Date ngayDienRa, String gioDienRa) {
        this.tenDoi1 = tenDoi1;
        this.tenDoi2 = tenDoi2;
        this.logoDoi1 = logoDoi1;
        this.logoDoi2 = logoDoi2;
        this.tengiaidau = tengiaidau;
        this.soBanDoi1 = soBanDoi1;
        this.soBanDoi2 = soBanDoi2;
        this.ngayDienRa = ngayDienRa;
        this.gioDienRa = gioDienRa;
    }

    public String getTenDoi1() {
        return tenDoi1;
    }

    public void setTenDoi1(String tenDoi1) {
        this.tenDoi1 = tenDoi1;
    }

    public String getTenDoi2() {
        return tenDoi2;
    }

    public void setTenDoi2(String tenDoi2) {
        this.tenDoi2 = tenDoi2;
    }

    public String getLogoDoi1() {
        return logoDoi1;
    }

    public void setLogoDoi1(String logoDoi1) {
        this.logoDoi1 = logoDoi1;
    }

    public String getLogoDoi2() {
        return logoDoi2;
    }

    public void setLogoDoi2(String logoDoi2) {
        this.logoDoi2 = logoDoi2;
    }

    public String getTengiaidau() {
        return tengiaidau;
    }

    public void setTengiaidau(String tengiaidau) {
        this.tengiaidau = tengiaidau;
    }

    public int getSoBanDoi1() {
        return soBanDoi1;
    }

    public void setSoBanDoi1(int soBanDoi1) {
        this.soBanDoi1 = soBanDoi1;
    }

    public int getSoBanDoi2() {
        return soBanDoi2;
    }

    public void setSoBanDoi2(int soBanDoi2) {
        this.soBanDoi2 = soBanDoi2;
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
}
