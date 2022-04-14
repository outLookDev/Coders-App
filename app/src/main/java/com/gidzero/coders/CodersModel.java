package com.gidzero.coders;

public class CodersModel {
    int img;
    String dec;
    String hex;

    public CodersModel(int img,  String dec, String hex) {
        this.img = img;
        this.dec = dec;
        this.hex = hex;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }



    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
