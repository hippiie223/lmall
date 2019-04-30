package com.lmall.mapper;

import com.lmall.domain.ArticlePost;
import com.lmall.domain.example.ArticlePostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArticlePostMapper {
    int countByExample(ArticlePostExample example);

    int deleteByExample(ArticlePostExample example);

    int insert(ArticlePost record);

    int insertSelective(ArticlePost record);

    List<ArticlePost> selectByExampleWithBLOBsWithRowbounds(ArticlePostExample example, RowBounds rowBounds);

    List<ArticlePost> selectByExampleWithBLOBs(ArticlePostExample example);

    List<ArticlePost> selectByExampleWithRowbounds(ArticlePostExample example, RowBounds rowBounds);

    List<ArticlePost> selectByExample(ArticlePostExample example);

    int updateByExampleSelective(@Param("record") ArticlePost record, @Param("example") ArticlePostExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticlePost record, @Param("example") ArticlePostExample example);

    int updateByExample(@Param("record") ArticlePost record, @Param("example") ArticlePostExample example);

    int postReply(@Param("postId") Integer postId);
}