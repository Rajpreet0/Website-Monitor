package com.websiteMonitor.model;

public class User {

    private int userId;
    private String name;
    private String email;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // Getter Methods
    public int getUserId(){
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
