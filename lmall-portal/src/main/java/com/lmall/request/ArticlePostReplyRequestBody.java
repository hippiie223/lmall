package com.lmall.request;

/**
 * @author 39239
 * @Date 2019/4/30 16:38
 * @Package com.lmall.request
 * @Description:
 */

public class ArticlePostReplyRequestBody {
    private Integer postId;
    private String content;
    private String userName;
    private String replyTo;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }
}
