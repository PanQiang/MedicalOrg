package com.controller;


import com.model.OuterLink;
import com.service.OuterLinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/outerLink")
@Slf4j
public class OuterLinkController {
	

    @Resource
    private OuterLinkService outerLinkService;

    /**
     * 外链列表查询
     * @param outerLink
     * @return
     */
    @RequestMapping("getList")
    public Map<String,Object> getList(OuterLink outerLink){
        log.info("官网外链列表查询,参数[{}]",outerLink);
        Map<String,Object> map = new HashMap<>();
        List<OuterLink> list = outerLinkService.getList(outerLink);
        map.put("list",list);
        return map;
    }


}
