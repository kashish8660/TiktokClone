package com.example.mytiktok;

public class Model {
    String videoUrl;

    public Model(String videoUrl, int profile, String name) {
        this.videoUrl = videoUrl;
        this.profile = profile;
        this.name = name;
    }

    int profile; //keeping int data type cuz we using images from drawable, if you using firebase then keep String datatype
    String name;

    public String getVideoUrl() {
        return videoUrl;
    }

//    public void setVideoUrl(String videoUrl) {
//        this.videoUrl = videoUrl;
//    }

    public int getProfile() {
        return profile;
    }

//    public void setProgile(int progile) {
//        this.profile = progile;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }


}
