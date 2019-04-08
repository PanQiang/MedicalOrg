package com.controller;


import com.github.pagehelper.PageInfo;
import com.model.Feedback;
import com.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
@Slf4j
public class FeedbackController {
	

    @Resource
    private FeedbackService feedbackService;

    /**
     * 分页查询列表
     * @param feedback
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @RequestMapping("selectByPage")
    public Map<String,Object> selectByPage(Feedback feedback, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        log.info("官网留言分页查询列表,参数[{}]",feedback);
        Map<String,Object> map = new HashMap<>();
        PageInfo<Feedback> pageInfo = feedbackService.listByPage(feedback, start, length);
        log.info("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("list", pageInfo.getList());
        return map;
    }

    /**
     * 不带分页查询列表
     * @param feedback
     * @return
     */
    @RequestMapping("listWithoutPage")
    public List<Feedback> listWithoutPage(Feedback feedback){
        log.info("官网留言不带分页查询列表,参数[{}]",feedback);
        List<Feedback> list = feedbackService.listWithoutPage(feedback);
        return list;
    }


    /*
     * 添加
     * @param feedback
     * @return
     */
    @RequestMapping("/save")
    public String add(Feedback feedback){
        log.info("官网留言,参数[{}]",feedback);
        try {

            Date date = new Date();
            Instant instant = date.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
            feedback.setCreateTime(localDateTime);
            feedback.setState(1);
            feedbackService.saveFeedback(feedback);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * 获取单条反馈信息
     * @param id
     * @return
     */
    @RequestMapping("/getOneById")
    @ResponseBody
    public Feedback getOneById(Long id){
        log.info("官网获取单条反馈信息,参数[{}]",id);
        try {
            Feedback feedback = feedbackService.selectByKey(id);
            return  feedback;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
