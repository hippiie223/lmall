package com.lmall.service;

import com.lmall.domain.*;
import com.lmall.response.ArticleRespBody;

import java.util.List;

/**
 * @author 39239
 * @Date 2019/4/30 13:55
 * @Package com.lmall.service
 * @Description:
 */

public interface ArticleService {
    List<ArticleRespBody> getAllArticleList(int pageNum, int pageSize);
    List<ArticleRespBody> getTopList();
    List<ArticleAuthorDTO> getTopAuthorList();
    List<ArticleRespBody> getSearchList(String keyWord, int pageNum, int pageSize);
    List<ArticleRespBody> getArticleDetail(String title, String authorName);
    List<ArticleRespBody> getArticleByAuthor(String authorName);
    void articlePost(ArticlePost articlePost);
    void articlePostReply(ArticlePostReply articlePostReply);
    void insertArticle(Article article);
    Integer getSortIdByName(String sortName);

}
