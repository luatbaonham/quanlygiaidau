package com.example.fe_quanlygiaidau.slide;

public class SlidePhoto {

    private int resource;
    private String text;

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SlidePhoto(int resource, String text) {
        this.resource = resource;
        this.text = text;
    }
}
