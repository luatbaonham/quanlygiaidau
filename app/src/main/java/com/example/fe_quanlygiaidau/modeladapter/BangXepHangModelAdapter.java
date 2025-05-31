package com.example.fe_quanlygiaidau.modeladapter;

import java.util.List;

public class BangXepHangModelAdapter {
    private String tenBang;
    private List<DoiBongModelAdapter> list;

    public BangXepHangModelAdapter(String tenBang, List<DoiBongModelAdapter> list) {
        this.tenBang = tenBang;
        this.list = list;
    }

    public BangXepHangModelAdapter() {
    }

    public String getTenBang() {
        return tenBang;
    }

    public void setTenBang(String tenBang) {
        this.tenBang = tenBang;
    }

    public List<DoiBongModelAdapter> getList() {
        return list;
    }

    public void setList(List<DoiBongModelAdapter> list) {
        this.list = list;
    }
}
