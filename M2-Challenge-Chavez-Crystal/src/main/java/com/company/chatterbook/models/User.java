package com.company.chatterbook.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    public List<ChatterPost> chatterPosts = new ArrayList<>();

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts){
        this.chatterPosts = chatterPosts;
    }

//    public List<ChatterPost> getChatterPosts(){
//        return this.chatterposts;
//    }
}