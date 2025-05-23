package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class KetQuaTranDau {
    @SerializedName("so_ban_doi_1")
    private int soBanDoi1;

    @SerializedName("so_ban_doi_2")
    private int soBanDoi2;

    @SerializedName("ma_tran_dau")
    private String maTranDau;

    @SerializedName("ma_doi_thang")
    private String maDoiThang;

    @SerializedName("ghi_chu")
    private String ghiChu;

    public KetQuaTranDau(int soBanDoi1, int soBanDoi2, String maTranDau, String maDoiThang, String ghiChu) {
        this.soBanDoi1 = soBanDoi1;
        this.soBanDoi2 = soBanDoi2;
        this.maTranDau = maTranDau;
        this.maDoiThang = maDoiThang;
        this.ghiChu = ghiChu;
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

    public String getMaTranDau() {
        return maTranDau;
    }

    public void setMaTranDau(String maTranDau) {
        this.maTranDau = maTranDau;
    }

    public String getMaDoiThang() {
        return maDoiThang;
    }

    public void setMaDoiThang(String maDoiThang) {
        this.maDoiThang = maDoiThang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
