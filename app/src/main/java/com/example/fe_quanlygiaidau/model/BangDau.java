package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class BangDau {
    @SerializedName("ma_bang_dau")
    private String maBangDau;

    @SerializedName("ten_bang_dau")
    private String tenBangDau;

    @SerializedName("ma_giai_dau")
    private String maGiaiDau;

    public BangDau(String maBangDau, String tenBangDau, String maGiaiDau) {
        this.maBangDau = maBangDau;
        this.tenBangDau = tenBangDau;
        this.maGiaiDau = maGiaiDau;
    }

    public String getMaBangDau() {
        return maBangDau;
    }

    public void setMaBangDau(String maBangDau) {
        this.maBangDau = maBangDau;
    }

    public String getTenBangDau() {
        return tenBangDau;
    }

    public void setTenBangDau(String tenBangDau) {
        this.tenBangDau = tenBangDau;
    }

    public String getMaGiaiDau() {
        return maGiaiDau;
    }

    public void setMaGiaiDau(String maGiaiDau) {
        this.maGiaiDau = maGiaiDau;
    }
}
