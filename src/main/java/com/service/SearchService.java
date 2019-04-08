package com.service;

import com.dto.SearchResult;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SearchService extends IService<SearchResult>{

     SearchResult searchCount(SearchResult searchResult);

     PageInfo<SearchResult> listByPage(SearchResult searchResult, int start, int length);
}
