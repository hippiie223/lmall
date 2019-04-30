package com.lmall.request;

/**
 * @author 39239
 * @Date 2019/4/30 16:16
 * @Package com.lmall.request
 * @Description:
 */

public class ArticlePostRequestBody {
    private Integer articleId;
    private String userName;
    private String content;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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
