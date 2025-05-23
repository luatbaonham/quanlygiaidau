package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class VongDau {
    @SerializedName("ma_vong_dau ")
    private String maVongDau;
    @SerializedName("ten_vong ")
    private String tenVong;
    @SerializedName("mo_ta")
    private String moTa;

    public VongDau(String maVongDau, String tenVong, String moTa) {
        this.maVongDau = maVongDau;
        this.tenVong = tenVong;
        this.moTa = moTa;
    }

    public String getMaVongDau() {
        return maVongDau;
    }

    public void setMaVongDau(String maVongDau) {
        this.maVongDau = maVongDau;
    }

    public String getTenVong() {
        return tenVong;
    }

    public void setTenVong(String tenVong) {
        this.tenVong = tenVong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
