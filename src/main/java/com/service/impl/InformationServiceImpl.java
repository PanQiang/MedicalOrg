package com.service.impl;

import com.mapper.InformationMapper;
import com.model.Information;
import com.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("informationService")
public class InformationServiceImpl extends BaseService<Information> implements InformationService {

	@Autowired
    InformationMapper informationMapper;

	@Override
	public void addOrUpdateInfo(Information information) {
		if(null != information.getId()){
			informationMapper.updateInformation(information);
		}else{
			informationMapper.insertSelective(information);
		}

	}

	@Override
	public Information getInfomation() {
		Information information = informationMapper.getInfomation();
		return information;
	}

	@Override
	public Information getAboutUs() {
		return informationMapper.getAboutUs();
	}

	@Override
	public Information getCallUs() {
		return informationMapper.getCallUs();
	}

	@Override
	public Information getLegalStatement() {
		return informationMapper.getLegalStatement();
	}
}
