package com.lmall.mapper;

import com.lmall.domain.ArticleAuthor;
import com.lmall.domain.ArticleAuthorDTO;
import com.lmall.domain.example.ArticleAuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArticleAuthorMapper {
    int countByExample(ArticleAuthorExample example);

    int deleteByExample(ArticleAuthorExample example);

    int insert(ArticleAuthor record);

    int insertSelective(ArticleAuthor record);

    List<ArticleAuthor> selectByExampleWithRowbounds(ArticleAuthorExample example, RowBounds rowBounds);

    List<ArticleAuthor> selectByExample(ArticleAuthorExample example);

    int updateByExampleSelective(@Param("record") ArticleAuthor record, @Param("example") ArticleAuthorExample example);

    int updateByExample(@Param("record") ArticleAuthor record, @Param("example") ArticleAuthorExample example);

    List<ArticleAuthorDTO> getTopAuthor();

    int changeArticleNum(@Param("authorName") String authorName);
}