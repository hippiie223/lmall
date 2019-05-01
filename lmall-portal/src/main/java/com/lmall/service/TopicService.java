package com.lmall.service;

import com.lmall.domain.Topic;
import com.lmall.domain.TopicPost;
import com.lmall.domain.TopicPostReply;
import com.lmall.response.TopicRespBody;

import java.util.List;

/**
 * @author 39239
 * @Date 2019/4/30 23:04
 * @Package com.lmall.service
 * @Description:
 */

public interface TopicService {
    List<TopicRespBody> getAllTopic(int pageNum, int pageSize);
    List<TopicRespBody> getTopTopic();
    List<TopicRespBody> getTopicDetail(String title, String authorName);
    void topicPost(TopicPost topicPost);
    void topicPostReply(TopicPostReply topicPostReply);
}
