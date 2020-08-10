package com.example.restuarant;

public class SetData {
    int image;
    String name,email;
    public SetData(int image,String avname,String avemail){
        this.name=avname;
        this.image=image;
        this.email=avemail;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
