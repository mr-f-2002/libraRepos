package com.example.demo11;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class setter {
    private String userName;
    private LocalDate postDate;
    private String postID;
    private String postContent;
    private int likeCount;
    private int dislikeCount;
    public void setUserName(String s) {this.userName = s;}
    public void setPostContent(String s){
        this.postContent = s;
    }
    public void setPostDate(LocalDate d){this.postDate = d;}
    public LocalDate getPostDate() {return postDate;}
    public String getPostContent() {
        return postContent;
    }
    public String getUserName() {
        return userName;
    }
    public int getLikeCount() {return likeCount;}
    public int getDislikeCount() {return dislikeCount;}
    public void setLikeCount(int likeCount) {this.likeCount = likeCount;}
    public void setDislikeCount(int dislikeCount) {this.dislikeCount = dislikeCount;}
    public String getPostID() {return postID;}
    public void setPostID(String postID) {this.postID = postID;}
}
