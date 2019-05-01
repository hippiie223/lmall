package com.lmall.mapper;

import com.lmall.domain.TopicSort;
import com.lmall.domain.example.TopicSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TopicSortMapper {
    int countByExample(TopicSortExample example);

    int deleteByExample(TopicSortExample example);

    int insert(TopicSort record);

    int insertSelective(TopicSort record);

    List<TopicSort> selectByExampleWithRowbounds(TopicSortExample example, RowBounds rowBounds);

    List<TopicSort> selectByExample(TopicSortExample example);

    int updateByExampleSelective(@Param("record") TopicSort record, @Param("example") TopicSortExample example);

    int updateByExample(@Param("record") TopicSort record, @Param("example") TopicSortExample example);
}