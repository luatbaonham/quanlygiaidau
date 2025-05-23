package com.example.fe_quanlygiaidau.model;

import java.io.Serializable;

public class News implements Serializable {
    private int Hinh;
    private String Title;
    private String Text;


    public News(int hinh, String title, String text) {
        Hinh = hinh;
        Title = title;
        Text = text;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
