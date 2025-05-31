package com.example.fe_quanlygiaidau.dto;

import java.util.Date;

public class Item_hienthi_cauthu {
    private String tenCauThu;
    private Date ngaySinh;
    private int soAo;
    private String viTri;
    private String hinhAnh;
    private String tenDoiBong;
    private String logo;
    private String maDoiBong;


    public Item_hienthi_cauthu(String tenCauThu, Date ngaySinh, int soAo, String viTri, String hinhAnh, String tenDoiBong, String logo, String maDoiBong ) {
        this.tenCauThu = tenCauThu;
        this.ngaySinh = ngaySinh;
        this.soAo = soAo;
        this.viTri = viTri;
        this.hinhAnh = hinhAnh;
        this.tenDoiBong = tenDoiBong;
        this.logo = logo;
        this.maDoiBong = maDoiBong;
    }

    public String getTenCauThu() {
        return tenCauThu;
    }

    public void setTenCauThu(String tenCauThu) {
        this.tenCauThu = tenCauThu;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getSoAo() {
        return soAo;
    }

    public void setSoAo(int soAo) {
        this.soAo = soAo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenDoiBong() {
        return tenDoiBong;
    }

    public void setTenDoiBong(String tenDoiBong) {
        this.tenDoiBong = tenDoiBong;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getMaDoiBong() {
        return maDoiBong;
    }

    public void setMaDoiBong(String maDoiBong) {
        this.maDoiBong = maDoiBong;
    }
}
