package com.gautamjain.techobyte.Modal;

public class Comment {

    private String comments;
    private String Publisher;

    public Comment(String comments, String Publisher) {
        this.comments = comments;
        this.Publisher = Publisher;
    }

    public String getComment() {
        return comments;
    }

    public void setComment(String comments) {
        this.comments = comments;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public String getPublisher() {
        return Publisher;
    }

}
