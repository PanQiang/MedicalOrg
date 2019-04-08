package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }


    /**
     * 跳转搜素结果
     * @return
     */
    @RequestMapping("/toSearchPage")
    public ModelAndView toSearchPage(String keyword){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("search/search");
        mv.addObject("keyword",keyword);
        return mv;
    }

    /**
     * 跳转新闻详情
     * @param id
     * @return
     */
    @RequestMapping("/toNewsDetail")
    public ModelAndView newsDetail(Long id,Integer place,Integer type){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("news/newsDetail");
        mv.addObject("id",id);
        mv.addObject("place",place);
        mv.addObject("type",type);
        return mv;
    }

    /**
     * 跳转到医保动态
     * @return
     */
    @RequestMapping("toMedicalNews")
    public String toMedocalNews(){
        return "news/medicalNewsList";
    }

    /**
     * 跳转到文字新闻
     * @return
     */
    @RequestMapping("toTextNews")
    public String toTextNews(){
        return "news/textNews";
    }

    /**
     * 跳转到专题报道
     * @return
     */
    @RequestMapping("toThemeNews")
    public String toThemeNews(){
        return "news/themeNews";
    }
    /**
     * 跳转到图片新闻
     * @return
     */
    @RequestMapping("toPicNews")
    public String toPicNews(){
        return "news/picNews";
    }


    /**
     * 跳转到专题报道
     * @return
     */
    @RequestMapping("toPolicyNews")
    public String toPolicyNews(){
        return "policyNews/policyNewsList";
    }

    /**
     * 跳转到专题报道
     * @return
     */
    @RequestMapping("toDownloadList")
    public String toDownloadList(){
        return "download/downloadList";
    }


    /**
     * 在下载列表页面点击更多
     * @return
     */
    @RequestMapping("/toMoreDownload")
    public ModelAndView toMoreDownload(Long type){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("download/listDownloadBytype");
        mv.addObject("type",type);
        return mv;
    }

    /**
     * 跳转下载详情
     * @param id
     * @return
     */
    @RequestMapping("/toDownloadDetail")
    public ModelAndView toDownloadDetail(Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("download/downloadDetail");
        mv.addObject("id",id);
        return mv;
    }


    /**
     * 跳转到居民互动
     * @return
     */
    @RequestMapping("toFeedback")
    public String toFeedback(){
        return "feedback/addFeedback";
    }

    /**
     * 跳转留言详情
     * @param id
     * @return
     */
    @RequestMapping("/toFeedbackDetail")
    public ModelAndView toFeedbackDetail(Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("feedback/feedbackDetail");
        mv.addObject("id",id);
        return mv;
    }

}
