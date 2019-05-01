package com.lmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.lmall.domain.Topic;
import com.lmall.domain.TopicDTO;
import com.lmall.domain.TopicPost;
import com.lmall.domain.TopicPostReply;
import com.lmall.domain.example.TopicExample;
import com.lmall.domain.example.TopicPostExample;
import com.lmall.mapper.ExtMapper;
import com.lmall.mapper.TopicMapper;
import com.lmall.mapper.TopicPostMapper;
import com.lmall.mapper.TopicPostReplyMapper;
import com.lmall.response.TopicRespBody;
import com.lmall.service.TopicService;
import com.lmall.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 39239
 * @Date 2019/4/30 23:04
 * @Package com.lmall.service.impl
 * @Description:
 */

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private ExtMapper extMapper;

    @Autowired
    private TopicPostMapper topicPostMapper;

    @Autowired
    private TopicPostReplyMapper topicPostReplyMapper;

    @Override
    public List<TopicRespBody> getAllTopic(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return extMapper.getAllTopicList().parallelStream().map(topicDTO -> {
            TopicRespBody topicRespBody = new TopicRespBody();
            topicRespBody.setId(topicDTO.getId());
            topicRespBody.setTitle(topicDTO.getTitle());
            topicRespBody.setAuthor(topicDTO.getAuthor());
            topicRespBody.setContent(topicDTO.getContent());
            topicRespBody.setPic(topicDTO.getPic());
            topicRespBody.setReviewNum(topicDTO.getReviewNum());
            topicRespBody.setViewNum(topicDTO.getViewNum());
            topicRespBody.setCreateTime(TimeUtil.getTime(topicDTO.getCreateTime()));
            return topicRespBody;
        }).collect(Collectors.toList());
    }

    @Override
    public List<TopicRespBody> getTopTopic() {
        return extMapper.getTopTopicList().parallelStream().map(topicDTO -> {
            TopicRespBody topicRespBody = new TopicRespBody();
            topicRespBody.setId(topicDTO.getId());
            topicRespBody.setTitle(topicDTO.getTitle());
            topicRespBody.setAuthor(topicDTO.getAuthor());
            topicRespBody.setContent(topicDTO.getContent());
            topicRespBody.setPic(topicDTO.getPic());
            topicRespBody.setReviewNum(topicDTO.getReviewNum());
            topicRespBody.setViewNum(topicDTO.getViewNum());
            topicRespBody.setCreateTime(TimeUtil.getTime(topicDTO.getCreateTime()));
            return topicRespBody;
        }).collect(Collectors.toList());
    }

    @Override
    public List<TopicRespBody> getTopicDetail(String title, String authorName) {
        return extMapper.getTopicDetail(title, authorName).parallelStream().map(topicDTO -> {
            TopicRespBody topicRespBody = new TopicRespBody();
            topicRespBody.setId(topicDTO.getId());
            topicRespBody.setTitle(topicDTO.getTitle());
            topicRespBody.setAuthor(topicDTO.getAuthor());
            topicRespBody.setContent(topicDTO.getContent());
            topicRespBody.setPic(topicDTO.getPic());
            topicRespBody.setReviewNum(topicDTO.getReviewNum());
            topicRespBody.setViewNum(topicDTO.getViewNum());
            topicRespBody.setCreateTime(TimeUtil.getTime(topicDTO.getCreateTime()));
            return topicRespBody;
        }).collect(Collectors.toList());

    }

    @Override
    public void topicPost(TopicPost topicPost) {
        topicPost.setCreateTime(TimeUtil.getCurrentTime());

        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria().andIdEqualTo(topicPost.getTopicId());
        Topic topic = new Topic();
        topic.setLastPostTime(TimeUtil.getCurrentTime());
        topicMapper.updateByExampleSelective(topic, topicExample);
        extMapper.updatePostNum(topicPost.getTopicId());

        topicPostMapper.insertSelective(topicPost);
    }

    @Override
    public void topicPostReply(TopicPostReply topicPostReply) {
        topicPostReply.setCreateTime(TimeUtil.getCurrentTime());

        TopicPostExample topicPostExample = new TopicPostExample();
        topicPostExample.createCriteria().andIdEqualTo(topicPostReply.getPostId());
        TopicPost topicPost = new TopicPost();
        topicPost.setLastReplyTime(TimeUtil.getCurrentTime());
        topicPostMapper.updateByExampleSelective(topicPost, topicPostExample);
        extMapper.updatePostReplyNum(topicPostReply.getPostId());

        topicPostReplyMapper.insertSelective(topicPostReply);
    }
}
