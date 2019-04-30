package com.lmall.mapper;

import com.lmall.domain.ArticleSort;
import com.lmall.domain.example.ArticleSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArticleSortMapper {
    int countByExample(ArticleSortExample example);

    int deleteByExample(ArticleSortExample example);

    int insert(ArticleSort record);

    int insertSelective(ArticleSort record);

    List<ArticleSort> selectByExampleWithRowbounds(ArticleSortExample example, RowBounds rowBounds);

    List<ArticleSort> selectByExample(ArticleSortExample example);

    int updateByExampleSelective(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);

    int updateByExample(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);
}