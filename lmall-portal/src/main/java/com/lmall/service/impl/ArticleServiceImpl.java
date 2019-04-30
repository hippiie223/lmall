package com.lmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.lmall.domain.*;
import com.lmall.domain.example.ArticleAuthorExample;
import com.lmall.domain.example.ArticleExample;
import com.lmall.domain.example.ArticlePostExample;
import com.lmall.domain.example.ArticleSortExample;
import com.lmall.mapper.*;
import com.lmall.response.ArticleRespBody;
import com.lmall.service.ArticleService;
import com.lmall.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 39239
 * @Date 2019/4/30 13:56
 * @Package com.lmall.service.impl
 * @Description:
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleAuthorMapper articleAuthorMapper;

    @Autowired
    private ArticlePostMapper articlePostMapper;

    @Autowired
    private ArticlePostReplyMapper articlePostReplyMapper;

    @Autowired
    private ArticleSortMapper articleSortMapper;


    @Override
    public List<ArticleRespBody> getAllArticleList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return articleMapper.getAllList().parallelStream().map(articleDTO -> {
            ArticleRespBody articleRespBody = new ArticleRespBody();
            articleRespBody.setId(articleDTO.getId());
            articleRespBody.setTitle(articleDTO.getTitle());
            articleRespBody.setAuthor(articleDTO.getAuthor());
            articleRespBody.setContent(articleDTO.getContent());
            articleRespBody.setPic(articleDTO.getPic());
            articleRespBody.setReviewNum(articleDTO.getReviewNum());
            articleRespBody.setViewNum(articleDTO.getViewNum());
            articleRespBody.setCreateTime(TimeUtil.getTime(articleDTO.getCreateTime()));
            return articleRespBody;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ArticleRespBody> getTopList() {
        return articleMapper.getTopList().parallelStream().map(articleDTO -> {
            ArticleRespBody articleRespBody = new ArticleRespBody();
            articleRespBody.setId(articleDTO.getId());
            articleRespBody.setTitle(articleDTO.getTitle());
            articleRespBody.setAuthor(articleDTO.getAuthor());
            articleRespBody.setContent(articleDTO.getContent());
            articleRespBody.setPic(articleDTO.getPic());
            articleRespBody.setReviewNum(articleDTO.getReviewNum());
            articleRespBody.setViewNum(articleDTO.getViewNum());
            articleRespBody.setCreateTime(TimeUtil.getTime(articleDTO.getCreateTime()));
            return articleRespBody;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ArticleAuthorDTO> getTopAuthorList() {
        return articleAuthorMapper.getTopAuthor();
    }

    @Override
    public List<ArticleRespBody> getSearchList(String keyWord, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return articleMapper.searchArticle(keyWord).parallelStream().map(articleDTO -> {
            ArticleRespBody articleRespBody = new ArticleRespBody();
            articleRespBody.setId(articleDTO.getId());
            articleRespBody.setTitle(articleDTO.getTitle());
            articleRespBody.setAuthor(articleDTO.getAuthor());
            articleRespBody.setContent(articleDTO.getContent());
            articleRespBody.setPic(articleDTO.getPic());
            articleRespBody.setReviewNum(articleDTO.getReviewNum());
            articleRespBody.setViewNum(articleDTO.getViewNum());
            articleRespBody.setCreateTime(TimeUtil.getTime(articleDTO.getCreateTime()));
            return articleRespBody;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ArticleRespBody> getArticleDetail(String title, String authorName) {
        return articleMapper.getArticle(title, authorName).parallelStream().map(articleDTO -> {
            ArticleRespBody articleRespBody = new ArticleRespBody();
            articleRespBody.setId(articleDTO.getId());
            articleRespBody.setTitle(articleDTO.getTitle());
            articleRespBody.setAuthor(articleDTO.getAuthor());
            articleRespBody.setContent(articleDTO.getContent());
            articleRespBody.setPic(articleDTO.getPic());
            articleRespBody.setReviewNum(articleDTO.getReviewNum());
            articleRespBody.setViewNum(articleDTO.getViewNum());
            articleRespBody.setCreateTime(TimeUtil.getTime(articleDTO.getCreateTime()));
            return articleRespBody;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ArticleRespBody> getArticleByAuthor(String authorName) {
        return articleMapper.getArticleByAuthor(authorName).parallelStream().map(articleDTO -> {
            ArticleRespBody articleRespBody = new ArticleRespBody();
            articleRespBody.setId(articleDTO.getId());
            articleRespBody.setTitle(articleDTO.getTitle());
            articleRespBody.setAuthor(articleDTO.getAuthor());
            articleRespBody.setContent(articleDTO.getContent());
            articleRespBody.setPic(articleDTO.getPic());
            articleRespBody.setReviewNum(articleDTO.getReviewNum());
            articleRespBody.setViewNum(articleDTO.getViewNum());
            articleRespBody.setCreateTime(TimeUtil.getTime(articleDTO.getCreateTime()));
            return articleRespBody;
        }).collect(Collectors.toList());
    }

    @Override
    public void articlePost(ArticlePost articlePost) {
        articlePost.setCreateTime(TimeUtil.getCurrentTime());
        ArticleExample example = new ArticleExample();
        example.createCriteria().andIdEqualTo(articlePost.getArticleId());
        Article article = new Article();
        article.setLastPostTime(TimeUtil.getCurrentTime());
        articleMapper.updateByExampleSelective(article, example);
        articleMapper.updatePostNum(articlePost.getArticleId());

        articlePostMapper.insertSelective(articlePost);
    }

    @Override
    public void articlePostReply(ArticlePostReply articlePostReply) {
        articlePostReply.setCreateTime(TimeUtil.getCurrentTime());
        ArticlePostExample example = new ArticlePostExample();
        example.createCriteria().andIdEqualTo(articlePostReply.getPostId());
        ArticlePost articlePost = new ArticlePost();
        articlePost.setLastReplyTime(TimeUtil.getCurrentTime());

        articlePostMapper.postReply(articlePostReply.getPostId());
        articlePostMapper.updateByExampleSelective(articlePost, example);

        articlePostReplyMapper.insertSelective(articlePostReply);
    }

    @Override
    public void insertArticle(Article article) {
        article.setCreateTime(TimeUtil.getCurrentTime());

        ArticleAuthorExample articleAuthorExample = new ArticleAuthorExample();
        articleAuthorExample.createCriteria().andAuthorNameEqualTo(article.getAuthorName());
        if(articleAuthorMapper.countByExample(articleAuthorExample) == 0){
            ArticleAuthor articleAuthor = new ArticleAuthor();
            articleAuthor.setAuthorName(article.getAuthorName());
            articleAuthor.setCreateTime(TimeUtil.getCurrentTime());
            articleAuthor.setArticleNum(0);
            articleAuthorMapper.insertSelective(articleAuthor);
        }
        articleAuthorMapper.changeArticleNum(article.getAuthorName());

        articleMapper.insertSelective(article);

    }

    @Override
    public Integer getSortIdByName(String sortName) {
        ArticleSortExample articleSortExample = new ArticleSortExample();
        articleSortExample.createCriteria().andSortNameEqualTo(sortName);
        return articleSortMapper.selectByExample(articleSortExample).get(0).getId();
    }
}
