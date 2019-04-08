package com.mapper;

import com.dto.SearchResult;
import com.util.MyMapper;

import java.util.List;

public interface SearchMapper extends MyMapper<SearchResult> {
    List<SearchResult> searchMedicalNews(SearchResult searchResult);

    List<SearchResult> searchPolicyNews(SearchResult searchResult);

    List<SearchResult> searchDownload(SearchResult searchResult);

    SearchResult searchCount(SearchResult searchResult);
}
