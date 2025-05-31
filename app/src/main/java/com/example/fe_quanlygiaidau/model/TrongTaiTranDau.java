package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class TrongTaiTranDau {
    @SerializedName("ma_tran_dau")
    private String maTrandau;
    @SerializedName("ma_trong_tai")
    private String maTrongTai;
    @SerializedName("ma_loai_trong_tai")
    private String maLoaiTrongtai;

    public TrongTaiTranDau(String maTrandau, String maTrongTai, String maLoaiTrongtai) {
        this.maTrandau = maTrandau;
        this.maTrongTai = maTrongTai;
        this.maLoaiTrongtai = maLoaiTrongtai;
    }

    public String getMaTrandau() {
        return maTrandau;
    }

    public void setMaTrandau(String maTrandau) {
        this.maTrandau = maTrandau;
    }

    public String getMaTrongTai() {
        return maTrongTai;
    }

    public void setMaTrongTai(String maTrongTai) {
        this.maTrongTai = maTrongTai;
    }

    public String getMaLoaiTrongtai() {
        return maLoaiTrongtai;
    }

    public void setMaLoaiTrongtai(String maLoaiTrongtai) {
        this.maLoaiTrongtai = maLoaiTrongtai;
    }
}
