package com.lmall.request;

/**
 * @author 39239
 * @Date 2019/5/2 01:04
 * @Package com.lmall.request
 * @Description:
 */

public class TopicPostRequestBody {
    private Integer topicId;
    private String userName;
    private String content;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
