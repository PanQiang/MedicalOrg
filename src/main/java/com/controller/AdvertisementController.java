package com.controller;


import com.model.Advertisement;
import com.service.AdvertisementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/advertisement")
@Slf4j
public class AdvertisementController {
	
    @Resource
    private AdvertisementService advertisementService;

    /**
     * 查询首页广告
     * @return
     */
    @RequestMapping("indexAdvertisement")
    public Map<String,Object> indexAdvertisement(Advertisement advertisement){
        log.info("医保官网首页广告列表查询");
        Map<String,Object> map = new HashMap<>();
        List<Advertisement> list = advertisementService.indexAdvertisement(advertisement);
        map.put("list", list);


        //测试sta提交代码
        //测试sta提交代码2
        //测试sta提交代码3
        //测试sta提交代码4
        //测试sta提交代码5
        //测试sta提交代码6
        //测试sta提交代码7
        //测试sta提交代码8
        //测试sta提交代码9
        //测试sta提交代码1000000

        return map;
    }
}
