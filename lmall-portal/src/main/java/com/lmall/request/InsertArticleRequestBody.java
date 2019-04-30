package com.lmall.request;

/**
 * @author 39239
 * @Date 2019/4/30 17:06
 * @Package com.lmall.request
 * @Description:
 */

public class InsertArticleRequestBody {
    private String title;
    private String authorName;
    private String content;
    private String pic;
    private String articleSort;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getArticleSort() {
        return articleSort;
    }

    public void setArticleSort(String articleSort) {
        this.articleSort = articleSort;
    }
}
