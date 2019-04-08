package com.controller;


import com.model.Information;
import com.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/information")
@Slf4j
public class InformationController {
	
    @Resource
    private InformationService informationService;

    /**
     * 查询备案信息
     * @return
     */
    @RequestMapping("/getInfomation")
    public Information getInfomation(){
        log.info("查询备案信息");
        try {
            Information information = informationService.getInfomation();
            return  information;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询关于我们
     * @return
     */
    @RequestMapping("/getAboutUs")
    public Information getAboutUs(){
        log.info("查询关于我们");
        try {
            Information information = informationService.getAboutUs();
            return  information;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询联系我们
     * @return
     */
    @RequestMapping("/getCallUs")
    public Information getCallUs(){
        log.info("查询联系我们");
        try {
            Information information = informationService.getCallUs();
            return  information;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询法律声明
     * @return
     */
    @RequestMapping("/getLegalStatement")
    public Information getLegalStatement(){
        log.info("查询法律声明");
        try {
            Information information = informationService.getLegalStatement();
            return  information;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
