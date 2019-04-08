package com.mapper;

import com.dto.DownloadDto;
import com.model.Download;
import com.model.DownloadType;
import com.util.MyMapper;

import java.util.List;

public interface DownloadMapper extends MyMapper<Download> {

    Download getOneById(Long id);

    List<Download> listOrderByloadCount(DownloadDto downloadDto);

    void addLoadCount(Download download);

    List<DownloadType> listDownloadType();

    List<Download> listMoreDownload(Download download);

    List<Download> listByPage(Download download);

    DownloadType getTypeNameByTypeId(Long id);
}
