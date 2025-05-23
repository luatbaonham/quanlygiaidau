package com.example.fe_quanlygiaidau.model;

import com.google.gson.annotations.SerializedName;

public class ViTriCauThu {
    @SerializedName("ma_vi_tri")
    private String maViTri;

    @SerializedName("ten_vi_tri")
    private String tenViTri;

    public ViTriCauThu(String maViTri, String tenViTri) {
        this.maViTri = maViTri;
        this.tenViTri = tenViTri;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }
}
