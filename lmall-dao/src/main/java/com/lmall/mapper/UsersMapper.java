package com.lmall.mapper;

import com.lmall.domain.Users;
import com.lmall.domain.example.UsersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UsersMapper {
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(String phone);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExampleWithRowbounds(UsersExample example, RowBounds rowBounds);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(String phone);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}