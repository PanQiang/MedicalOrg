package com.mapper;

import com.dto.NewsParamDto;
import com.model.News;
import com.util.MyMapper;

import java.util.List;

public interface NewsMapper extends MyMapper<News> {


    List<News> getOneById(Long id);

    List<News> getAll(News news);

    List<News> getIndexNews(News news);

    List<News> getIndexHotNews(News news);

    List<News> getOrgPolicy(News news);

    List<News> getOrgPolicyType(News news);

    void addReadCount(News news);

    News getPreNews(News news);
    News getNextNews(News news);

    List<News> getMoreMedicleNews();

    List<News> getSpecialNews();

    List<News> getPictureNews();

    List<News> getAllOrgPolicyWithoutType();
}