package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class LoaiTrongTai {
    @SerializedName("ma_loai_trong_tai ")
    private String maLoaiTrongTai;
    @SerializedName("ten_loai_trong_tai")
    private String tenLoaiTrongTai;

    public LoaiTrongTai(String maLoaiTrongTai, String tenLoaiTrongTai) {
        this.maLoaiTrongTai = maLoaiTrongTai;
        this.tenLoaiTrongTai = tenLoaiTrongTai;
    }

    public String getMaLoaiTrongTai() {
        return maLoaiTrongTai;
    }

    public void setMaLoaiTrongTai(String maLoaiTrongTai) {
        this.maLoaiTrongTai = maLoaiTrongTai;
    }

    public String getTenLoaiTrongTai() {
        return tenLoaiTrongTai;
    }

    public void setTenLoaiTrongTai(String tenLoaiTrongTai) {
        this.tenLoaiTrongTai = tenLoaiTrongTai;
    }
}
