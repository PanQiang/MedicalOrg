package com.service;

import com.dto.DownloadDto;
import com.github.pagehelper.PageInfo;
import com.model.Download;
import com.model.DownloadType;
import com.model.News;

import java.util.List;

public interface DownloadService extends IService<Download> {

    Download getOneById(Long id);

    List<Download> listOrderByloadCount(DownloadDto downloadDto);

    List<DownloadType> listDownloadType();

    List<Download> listMoreDownload(Download download);

    PageInfo<Download> listByPage(Download download, int start, int length);

    void addLoadCount(Download download);

    DownloadType getTypeNameByTypeId(Long id);
}
