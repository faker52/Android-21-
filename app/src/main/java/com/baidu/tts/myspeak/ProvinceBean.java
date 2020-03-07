package com.baidu.tts.myspeak;

public class ProvinceBean {
    private String name;
    private int color;

    public ProvinceBean(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public ProvinceBean() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
