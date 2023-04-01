package com.example.migma.entity;

public class FaqModel {
    private String profile_name;
    private double profile_rating;
    private String feedback_details;
    private String uid;

    public FaqModel(String uid, String profile_name, double profile_rating, String feedback_details) {
        this.uid = uid;
        this.profile_name = profile_name;
        this.profile_rating = profile_rating;
        this.feedback_details = feedback_details;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public FaqModel(){

    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    public double getProfile_rating() {
        return profile_rating;
    }

    public void setProfile_rating(double profile_rating) {
        this.profile_rating = profile_rating;
    }

    public String getFeedback_details() {
        return feedback_details;
    }

    public void setFeedback_details(String feedback_details) {
        this.feedback_details = feedback_details;
    }
}

