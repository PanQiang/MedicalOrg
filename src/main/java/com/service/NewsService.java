package com.service;

import com.dto.NewsParamDto;
import com.github.pagehelper.PageInfo;
import com.model.News;

import java.util.List;

public interface NewsService extends IService<News> {
	
	PageInfo<News> listByPage(News news, int start, int length);
	News getOneById(Long id);

	List<News> getIndexNews(News news);

	List<News> getIndexHotNews(News news);

	List<News> getOrgPolicy(News news);

	List<News> getOrgPolicyType(News news);

    News getPreNews(News news);

	News getNextNews(News news);

	List<News> getMoreMedicleNews();

	List<News> getSpecialNews();

	List<News> getPictureNews();

	List<News> getAllOrgPolicyWithoutType();
}
