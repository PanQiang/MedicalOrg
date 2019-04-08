package com.controller;


import com.dto.SearchResult;
import com.github.pagehelper.PageInfo;
import com.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {
	
    @Resource
    private SearchService searchService;


    /**
     * 搜索关键词的各类条目数量
     * @return
     */
    @RequestMapping("searchCount")
    public SearchResult searchCount(SearchResult searchResult){
        log.info("搜索关键词的各类条目数量");
        searchResult = searchService.searchCount(searchResult);
        return searchResult;
    }



    /**
     * 关键词搜索，携带类型参数
     * @param searchResult
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @RequestMapping("searchByType")
    public Map<String,Object> searchByType(SearchResult searchResult, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        log.info("关键词搜索,参数[{}]",searchResult);
        Map<String,Object> map = new HashMap<>();
        PageInfo<SearchResult> pageInfo = searchService.listByPage(searchResult, start, length);
        log.info("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("list", pageInfo.getList());
        return map;
    }
}
