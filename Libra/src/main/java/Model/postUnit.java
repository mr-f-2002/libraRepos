package Model;

public class postUnit {
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getCmntCount() {
        return cmntCount;
    }

    public void setCmntCount(int cmntCount) {
        this.cmntCount = cmntCount;
    }

    public String getLikeImgSrc() {
        return likeImgSrc;
    }

    public void setLikeImgSrc(String likeImgSrc) {
        this.likeImgSrc = likeImgSrc;
    }

    public String getDislikeImgSrc() {
        return dislikeImgSrc;
    }

    public void setDislikeImgSrc(String dislikeImgSrc) {
        this.dislikeImgSrc = dislikeImgSrc;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    private String userid;
    private String category;
    private String date;
    private String postBody;
    private int likeCount;
    private int dislikeCount;
    private int cmntCount;
    private String likeImgSrc;
    private String dislikeImgSrc;
    private String postId;
}
