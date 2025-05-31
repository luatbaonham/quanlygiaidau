package com.example.fe_quanlygiaidau.modeladapter;

public class TranDauModelAdapter {
    private String hinhAnhDoi1;
    private String tenDoi1;
    private String hinhAnhDoi2;
    private String tenDoi2;
    private String vongdau;
    private String tyso;
    private String gio;
    private String ngay;
    private String sanvandong;

    public TranDauModelAdapter() {
    }

    public TranDauModelAdapter(String hinhAnhDoi1, String tenDoi1, String tenDoi2, String hinhAnhDoi2, String vongdau, String tyso, String ngay, String gio, String sanvandong) {
        this.hinhAnhDoi1 = hinhAnhDoi1;
        this.tenDoi1 = tenDoi1;
        this.tenDoi2 = tenDoi2;
        this.hinhAnhDoi2 = hinhAnhDoi2;
        this.vongdau = vongdau;
        this.tyso = tyso;
        this.ngay = ngay;
        this.gio = gio;
        this.sanvandong = sanvandong;
    }

    public String getHinhAnhDoi1() {
        return hinhAnhDoi1;
    }

    public void setHinhAnhDoi1(String hinhAnhDoi1) {
        this.hinhAnhDoi1 = hinhAnhDoi1;
    }

    public String getTenDoi1() {
        return tenDoi1;
    }

    public void setTenDoi1(String tenDoi1) {
        this.tenDoi1 = tenDoi1;
    }

    public String getHinhAnhDoi2() {
        return hinhAnhDoi2;
    }

    public void setHinhAnhDoi2(String hinhAnhDoi2) {
        this.hinhAnhDoi2 = hinhAnhDoi2;
    }

    public String getTenDoi2() {
        return tenDoi2;
    }

    public void setTenDoi2(String tenDoi2) {
        this.tenDoi2 = tenDoi2;
    }

    public String getVongdau() {
        return vongdau;
    }

    public void setVongdau(String vongdau) {
        this.vongdau = vongdau;
    }

    public String getTyso() {
        return tyso;
    }

    public void setTyso(String tyso) {
        this.tyso = tyso;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getSanvandong() {
        return sanvandong;
    }

    public void setSanvandong(String sanvandong) {
        this.sanvandong = sanvandong;
    }
}
