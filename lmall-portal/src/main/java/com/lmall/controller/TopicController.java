package com.lmall.controller;

import com.lmall.domain.TopicPost;
import com.lmall.domain.TopicPostReply;
import com.lmall.request.TopicPostReplyRequestBody;
import com.lmall.request.TopicPostRequestBody;
import com.lmall.respbody.RootRespBody;
import com.lmall.response.TopicRespBody;
import com.lmall.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;

/**
 * @author 39239
 * @Date 2019/4/30 23:10
 * @Package com.lmall.controller
 * @Description:
 */

@Api("话题相关接口")
@RestController
@RequestMapping(path = "/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping(path = "/get/all/topic")
    @ApiOperation("获取所有话题")
    public RootRespBody<List<TopicRespBody>> getAllList(@RequestParam int pageNum, @RequestParam int pageSize){
        return RootRespBody.success(topicService.getAllTopic(pageNum, pageSize));
    }

    @GetMapping(path = "/get/top/topic")
    @ApiOperation("获取前十话题")
    public RootRespBody<List<TopicRespBody>> getTopList(){
        return RootRespBody.success(topicService.getTopTopic());
    }

    @GetMapping(path = "/get/detail")
    @ApiOperation("获取文章详情")
    public RootRespBody<List<TopicRespBody>> getTopicDetail(@RequestParam String title, @RequestParam String authorName){
        return RootRespBody.success(topicService.getTopicDetail(title, authorName));
    }

    @PostMapping(path = "/post")
    public RootRespBody topicPost(@RequestBody TopicPostRequestBody requestBody){
        if(requestBody.getTopicId() == 0){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "话题id不能为空");
        }
        if("".equals(requestBody.getUserName()) || requestBody.getUserName() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "用户名称不能为空");
        }
        if("".equals(requestBody.getContent()) || requestBody.getContent() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "评论内容不能为空");
        }

        TopicPost topicPost = new TopicPost();
        topicPost.setContent(requestBody.getContent());
        topicPost.setUserName(requestBody.getUserName());
        topicPost.setTopicId(requestBody.getTopicId());
        topicService.topicPost(topicPost);

        return RootRespBody.success();
    }

    @PostMapping(path = "reply")
    @ApiOperation("话题回复")
    public RootRespBody topicPostReply(@RequestBody TopicPostReplyRequestBody replyRequestBody){
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

        TopicPostReply topicPostReply = new TopicPostReply();
        topicPostReply.setPostId(replyRequestBody.getPostId());
        topicPostReply.setContent(replyRequestBody.getContent());
        topicPostReply.setUserName(replyRequestBody.getUserName());
        topicPostReply.setReplyToUser(replyRequestBody.getReplyTo());

        topicService.topicPostReply(topicPostReply);
        return RootRespBody.success();
    }
}
