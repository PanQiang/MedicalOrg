package com.service.impl;

import com.dto.DownloadDto;
import com.dto.NewsParamDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DownloadMapper;
import com.model.Download;
import com.model.DownloadType;
import com.model.News;
import com.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("downloadService")
public class DownloadServiceImpl extends BaseService<Download> implements DownloadService {

	@Autowired
	private DownloadMapper downloadMapper;

	@Override
	public PageInfo<Download> listByPage(Download download, int start, int length) {
		int page = start/length+1;
		PageHelper.startPage(page, length);
		List<Download> list = downloadMapper.listByPage(download);

		return new PageInfo<>(list);
	}

	@Override
	public Download getOneById(Long id) {
		Download download = downloadMapper.getOneById(id);
		return download;
	}


	@Override
	public List<Download> listOrderByloadCount(DownloadDto downloadDto) {
		List<Download> list = downloadMapper.listOrderByloadCount(downloadDto);
		return list;
	}

	@Override
	public List<DownloadType> listDownloadType() {
		return downloadMapper.listDownloadType();
	}

	@Override
	public List<Download> listMoreDownload(Download download) {
		return downloadMapper.listMoreDownload(download);
	}


	@Override
	public void addLoadCount(Download download){
		if(download.getId()!=null&&download.getLoadCount()!=null){
			download.setLoadCount(download.getLoadCount()+1);
			downloadMapper.addLoadCount(download);
		}
	}

	@Override
	public DownloadType getTypeNameByTypeId(Long id) {

		return downloadMapper.getTypeNameByTypeId(id);
	}

}
