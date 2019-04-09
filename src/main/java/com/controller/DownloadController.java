package com.controller;


import com.dto.DownloadDto;
import com.dto.NewsParamDto;
import com.github.pagehelper.PageInfo;
import com.model.Download;
import com.model.DownloadType;
import com.model.News;
import com.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/download")
@Slf4j
public class DownloadController {
	
    @Resource
    private DownloadService downloadService;


    /**
     * 分页查询下载
     * @param download
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @RequestMapping("getAll")
    public Map<String,Object> getAll(Download download, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "24") int length){
        log.info("官网下载列表查询,参数[{}]",download,length);
        Map<String,Object> map = new HashMap<>();
        PageInfo<Download> pageInfo = downloadService.listByPage(download, start, length);
        log.info("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("pages",pageInfo.getPages());
        map.put("list", pageInfo.getList());
        return map;
    }


    /**
     * 首页按下载量倒叙查询下载列表
     * @param downloadDto
     * @return
     */
    @RequestMapping("listOrderByloadCount")
    public Map<String,Object> listOrderByloadCount(DownloadDto downloadDto){
        log.info("官网文件下载列表查询,参数[{}]",downloadDto);
        Map<String,Object> map = new HashMap<>();
        List<Download> list = downloadService.listOrderByloadCount(downloadDto);
        map.put("list", list);
        return map;
    }

    /**
     * 获得单条下载信息
     * @param id
     * @return
     */
    @RequestMapping("/getOneById")
    public Download getOneById(Long id){
        log.info("官网查询单个下载信息,参数[{}]",id);
        try {
            Download download = downloadService.getOneById(id);
            return  download;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询所有的下载分类
     * @return
     */
    @RequestMapping("listDownloadType")
    public Map<String,Object> listDownloadType(){
        log.info("查询所有的下载分类");
        Map<String,Object> map = new HashMap<>();
        List<DownloadType> list = downloadService.listDownloadType();
        map.put("list", list);
        return map;
    }

    /**
     * 根据id查询分类名称
     * @return
     */
    @RequestMapping("getTypeNameByTypeId")
    @ResponseBody
    public DownloadType getTypeNameByTypeId(Long id){
        log.info("根据id查询分类名称");
        DownloadType downloadType = downloadService.getTypeNameByTypeId(id);
        return downloadType;
    }

    /**
     * 根据类型查询下载
     * @return
     */
    @RequestMapping("listMoreDownloadByType")
    public Map<String,Object> listMoreDownload(Download download){
        log.info("首页点击顶部下载专区和下载专区的更多，参数："+download);
        Map<String,Object> map = new HashMap<>();
        List<Download> list = downloadService.listMoreDownload(download);
        map.put("list", list);
        return map;
    }

    /**
     * 点击下载增加下载次数
     * @return
     */
    @RequestMapping("addLoadCount")
    public void addLoadCount(Download download){
        log.info("点击下载增加下载次数，参数："+download);
        downloadService.addLoadCount(download);
    }




}
