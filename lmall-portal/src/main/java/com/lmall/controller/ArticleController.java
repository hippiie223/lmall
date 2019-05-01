package com.lmall.controller;

import com.lmall.domain.*;
import com.lmall.request.ArticlePostReplyRequestBody;
import com.lmall.request.ArticlePostRequestBody;
import com.lmall.request.InsertArticleRequestBody;
import com.lmall.respbody.RootRespBody;
import com.lmall.response.ArticleRespBody;
import com.lmall.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 39239
 * @Date 2019/4/30 13:58
 * @Package com.lmall.controller
 * @Description:
 */

@Api("文章相关接口")
@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping(path = "/get/all/article")
    @ApiOperation("所有文章列表")
    public RootRespBody<List<ArticleRespBody>> getAllArticleList(@RequestParam int pageNum, @RequestParam int pageSize){
        return RootRespBody.success(articleService.getAllArticleList(pageNum, pageSize));
    }

    @GetMapping(path = "/get/top/article")
    @ApiOperation("获取热门文章前十")
    public RootRespBody<List<ArticleRespBody>> getTopArticleList(){
        return RootRespBody.success(articleService.getTopList());
    }

    @GetMapping(path = "/get/top/author")
    @ApiOperation("获取优秀作者前十")
    public RootRespBody<List<ArticleAuthorDTO>> getTopAuthorList(){
        return RootRespBody.success(articleService.getTopAuthorList());
    }

    @GetMapping(path = "/get/search/article")
    @ApiOperation("关键字搜索文章")
    public RootRespBody<List<ArticleRespBody>> getSearch(@RequestParam String keyWord, @RequestParam int pageNum, @RequestParam int pageSize){
        return RootRespBody.success(articleService.getSearchList(keyWord, pageNum, pageSize));
    }

    @GetMapping(path = "/get/article/detail")
    @ApiOperation("根据文章名和作者获取文章信息")
    public RootRespBody<List<ArticleRespBody>> getArticleDetail(@RequestParam String title, @RequestParam String authorName){
        return RootRespBody.success(articleService.getArticleDetail(title, authorName));
    }

    @GetMapping(path = "/get/article/by/author")
    @ApiOperation("获取作者的其他文章")
    public RootRespBody<List<ArticleRespBody>> getArticleByAuthor(@RequestParam String authorName){
        return RootRespBody.success(articleService.getArticleByAuthor(authorName));
    }

    @PostMapping(path = "/post/article")
    @ApiOperation("文章评论")
    public RootRespBody articlePost(@RequestBody ArticlePostRequestBody requestBody){
        if(requestBody.getArticleId() == 0){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "文章id不能为空");
        }
        if("".equals(requestBody.getUserName()) || requestBody.getUserName() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "用户名称不能为空");
        }
        if("".equals(requestBody.getContent()) || requestBody.getContent() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "评论内容不能为空");
        }

        ArticlePost articlePost = new ArticlePost();
        articlePost.setArticleId(requestBody.getArticleId());
        articlePost.setContent(requestBody.getContent());
        articlePost.setUserName(requestBody.getUserName());
        articleService.articlePost(articlePost);

        return RootRespBody.success();
    }

    @PostMapping(path = "/post/reply")
    @ApiOperation("评论回复")
    public RootRespBody postReply(@RequestBody ArticlePostReplyRequestBody replyRequestBody){
        if(replyRequestBody.getPostId() == 0){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "评论id不能为空");
        }
        if("".equals(replyRequestBody.getUserName()) || replyRequestBody.getUserName() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "用户名称不能为空");
        }
        if("".equals(replyRequestBody.getReplyTo()) || replyRequestBody.getReplyTo() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "回复用户不能为空");
        }
        if("".equals(replyRequestBody.getContent()) || replyRequestBody.getContent() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "回复内容不能为空");
        }

        ArticlePostReply articlePostReply = new ArticlePostReply();
        articlePostReply.setPostId(replyRequestBody.getPostId());
        articlePostReply.setContent(replyRequestBody.getContent());
        articlePostReply.setUserName(replyRequestBody.getUserName());
        articlePostReply.setReplyToUser(replyRequestBody.getReplyTo());

        articleService.articlePostReply(articlePostReply);
        return RootRespBody.success();
    }

    @PostMapping("/insert")
    @ApiOperation("发布文章")
    public RootRespBody insertArticle(@RequestBody InsertArticleRequestBody requestBody){
        Article article = new Article();

        article.setTitle(requestBody.getTitle());
        article.setContent(requestBody.getContent());
        article.setImgUrl(requestBody.getPic());
        article.setAuthorName(requestBody.getAuthorName());
        article.setArticleSortId(articleService.getSortIdByName(requestBody.getArticleSort()));

        try {
            articleService.insertArticle(article);
        }catch (Exception e){
            return RootRespBody.failure(RootRespBody.Status.INSERT_RECORD_ERROR,"文章已存在");
        }

        return RootRespBody.success();
    }
}
