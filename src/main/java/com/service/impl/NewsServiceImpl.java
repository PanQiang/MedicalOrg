package com.service.impl;

import com.dto.NewsParamDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.NewsMapper;
import com.model.News;
import com.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsService")
public class NewsServiceImpl extends BaseService<News> implements NewsService {

	@Autowired
	private NewsMapper newsMapper;


	@Override
	public PageInfo<News> listByPage(News news, int start, int length) {
        int page = start/length+1;
        PageHelper.startPage(page, length);
		List<News> newsList = newsMapper.getAll(news);

        return new PageInfo<>(newsList);
	}

	//根据ID获取数据
	@Override
	public News getOneById(Long id) {

		List<News> list = newsMapper.getOneById(id);
		if(list.get(0)!=null&&list.get(0).getReadCount()!=null){
			News news = new News();
			news.setReadCount(list.get(0).getReadCount()+1);
			news.setId(list.get(0).getId());
			newsMapper.addReadCount(news);
		}

		return list.get(0);
	}

	@Override
	public List<News> getIndexNews(News news) {
		List<News> list = newsMapper.getIndexNews(news);
		return list;
	}

	@Override
	public List<News> getIndexHotNews(News news) {
		List<News> list = newsMapper.getIndexHotNews(news);
		return list;
	}

	@Override
	public List<News> getOrgPolicy(News news) {
		List<News> list = newsMapper.getOrgPolicy(news);
		return list;
	}

	@Override
	public List<News> getOrgPolicyType(News news) {
		List<News> list = newsMapper.getOrgPolicyType(news);
		return list;
	}

	@Override
	public News getPreNews(News news) {
		return newsMapper.getPreNews(news);
	}

	@Override
	public News getNextNews(News news) {
		return newsMapper.getNextNews(news);
	}

	@Override
	public List<News> getMoreMedicleNews() {
		return newsMapper.getMoreMedicleNews();
	}

	@Override
	public List<News> getSpecialNews() {
		return newsMapper.getSpecialNews();
	}

	@Override
	public List<News> getPictureNews() {
		return newsMapper.getPictureNews();
	}

	@Override
	public List<News> getAllOrgPolicyWithoutType() {
		return newsMapper.getAllOrgPolicyWithoutType();
	}


}
