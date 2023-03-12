package com.example.demo11;

public class setter {
    private String userName;
    private String postContent;
    public void setUserName(String s) {
        this.userName = s;
    }
    public void setPostContent(String s){
        this.postContent = s;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getUserName() {
        return userName;
    }
}
