package com.lmall.domain;

import java.util.Date;

public class ArticleAuthor {
    private Integer id;

    private String authorName;

    private Integer articleNum;

    private Date createTime;

    private Date updateTime;

    private Integer topicNum;

    private Integer qaNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(Integer topicNum) {
        this.topicNum = topicNum;
    }

    public Integer getQaNum() {
        return qaNum;
    }

    public void setQaNum(Integer qaNum) {
        this.qaNum = qaNum;
    }
}