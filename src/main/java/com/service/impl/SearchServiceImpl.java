package com.service.impl;

import com.dto.SearchResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.SearchMapper;
import com.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchService")
public class SearchServiceImpl extends BaseService<SearchResult> implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public SearchResult searchCount(SearchResult searchResult) {
        return searchMapper.searchCount(searchResult);
    }

    @Override
    public PageInfo<SearchResult> listByPage(SearchResult searchResult, int start, int length) {

        int page = start/length+1;
        PageHelper.startPage(page, length);
        List<SearchResult> list= null;
        if(searchResult.getType()==1){
             list = searchMapper.searchMedicalNews(searchResult);
        }else if(searchResult.getType()==2){
            list = searchMapper.searchPolicyNews(searchResult);
        }else if(searchResult.getType()==3){
             list = searchMapper.searchDownload(searchResult);
        }

        return new PageInfo<>(list);
    }
}
