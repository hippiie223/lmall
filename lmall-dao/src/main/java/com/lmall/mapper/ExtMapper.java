package com.lmall.mapper;

import com.lmall.domain.TopicDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 39239
 * @Date 2019/4/30 23:34
 * @Package com.lmall.mapper
 * @Description:
 */

public interface ExtMapper {
    List<TopicDTO> getAllTopicList();
    List<TopicDTO> getTopTopicList();
    List<TopicDTO> getTopicDetail(@Param("title") String title, @Param("authorName") String authorName);
    int updatePostNum(@Param("topicId") Integer topicId);
    int updatePostReplyNum(@Param("postId") Integer postId);
}
