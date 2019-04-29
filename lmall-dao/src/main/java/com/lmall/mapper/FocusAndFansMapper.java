package com.lmall.mapper;

import com.lmall.domain.FocusAndFans;
import com.lmall.domain.example.FocusAndFansExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FocusAndFansMapper {
    int countByExample(FocusAndFansExample example);

    int deleteByExample(FocusAndFansExample example);

    int insert(FocusAndFans record);

    int insertSelective(FocusAndFans record);

    List<FocusAndFans> selectByExampleWithRowbounds(FocusAndFansExample example, RowBounds rowBounds);

    List<FocusAndFans> selectByExample(FocusAndFansExample example);

    int updateByExampleSelective(@Param("record") FocusAndFans record, @Param("example") FocusAndFansExample example);

    int updateByExample(@Param("record") FocusAndFans record, @Param("example") FocusAndFansExample example);
}