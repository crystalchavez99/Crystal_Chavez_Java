package com.company.chatterbook.models;

public class ChatterPost {
    public String text;

    public ChatterPost(){};

    public ChatterPost(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
