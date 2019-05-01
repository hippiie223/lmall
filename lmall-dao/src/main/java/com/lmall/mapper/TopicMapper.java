package com.lmall.mapper;

import com.lmall.domain.Topic;
import com.lmall.domain.TopicDTO;
import com.lmall.domain.example.TopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TopicMapper {
    int countByExample(TopicExample example);

    int deleteByExample(TopicExample example);

    int insert(Topic record);

    int insertSelective(Topic record);

    List<Topic> selectByExampleWithBLOBsWithRowbounds(TopicExample example, RowBounds rowBounds);

    List<Topic> selectByExampleWithBLOBs(TopicExample example);

    List<Topic> selectByExampleWithRowbounds(TopicExample example, RowBounds rowBounds);

    List<Topic> selectByExample(TopicExample example);

    int updateByExampleSelective(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExampleWithBLOBs(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExample(@Param("record") Topic record, @Param("example") TopicExample example);

    List<TopicDTO> getAllList();

    List<TopicDTO> getTopList();
}