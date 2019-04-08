package com.controller;


import com.dto.NewsParamDto;
import com.github.pagehelper.PageInfo;
import com.model.News;
import com.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {
	
    @Resource
    private NewsService newsService;

    /**
     * 新闻列表分页查询
     * @param news
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @RequestMapping
    public Map<String,Object> getAll(News news, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        log.info("官网新闻列表查询,参数[{}]",news,length);
        Map<String,Object> map = new HashMap<>();
        PageInfo<News> pageInfo = newsService.listByPage(news, start, length);
        log.info("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("list", pageInfo.getList());
        return map;
    }

    /**
     * 首页点击医保动态的更多
     * @return
     */
    @RequestMapping("getMoreNews")
    public Map<String,Object> getMoreNews(){
        log.info("更多医保动态");
        Map<String,Object> map = new HashMap<>();

        //医保动态
        List<News> list1 = newsService.getMoreMedicleNews();
        //专题报道
        List<News> list2 = newsService.getSpecialNews();
        //图片新闻
        List<News> list3 = newsService.getPictureNews();

        map.put("list1", list1);
        map.put("list2", list2);
        map.put("list3", list3);
        return map;
    }


    /**
     * 获得单条新闻信息
     * @param news
     * @return
     */
    @RequestMapping("/getOneById")
    public Map<String,Object> getOneById(News news){
        log.info("官网获得单条新闻信息,参数[{}]",news);
        try {
            Map<String,Object> map = new HashMap<>();

            //查询当前新闻的信息
            News nowNews = newsService.getOneById(news.getId());

            //查询上一条新闻的信息
            News preNews = newsService.getPreNews(news);
            //查询下一条新闻的信息
            News nextNews = newsService.getNextNews(news);

            map.put("news",nowNews);
            map.put("preNews",preNews);
            map.put("nextNews",nextNews);
            return  map;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 首页展示医保动态
     * @param news
     * @return
     */
    @RequestMapping("getIndexNews")
    public Map<String,Object> getIndexNews(News news){
        log.info("首页展示医保动态");
        Map<String,Object> map = new HashMap<>();
        List<News> list1 = newsService.getIndexNews(news);
        List<News> list2 = newsService.getIndexHotNews(news);
        map.put("list1", list1);
        map.put("list2", list2);
        return map;
    }

    /**
     * 加载政务公开页签
     * @return
     */
    @RequestMapping("getOrgPolicyTips")
    @ResponseBody
    public Map<String,Object> getOrgPolicyTips(News news){
        log.info("加载政务公开页签");
        Map<String,Object> map = new HashMap<>();
        List<News> list = newsService.getOrgPolicyType(news);
        map.put("list", list);
        return map;
    }

    /**
     * 首页展示政务公开,根据页签传递的类型
     * @return
     */
    @RequestMapping("getOrgPolicy")
    @ResponseBody
    public Map<String,Object> getOrgPolicy(News news){
        log.info("首页展示政务公开");
        Map<String,Object> map = new HashMap<>();
        List<News> list = newsService.getOrgPolicy(news);
        map.put("list", list);
        return map;
    }

    /**
     * 首页点击顶部政务公开，或者首页点击政务公开的更多
     * @return
     */
    @RequestMapping("getAllOrgPolicyWithoutType")
    @ResponseBody
    public Map<String,Object> getAllOrgPolicyWithoutType(){
        log.info("首页点击顶部政务公开，或者首页点击政务公开的更多");
        Map<String,Object> map = new HashMap<>();
        List<News> list = newsService.getAllOrgPolicyWithoutType();
        map.put("list", list);
        return map;
    }




}
