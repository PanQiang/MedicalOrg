package com.service.impl;

import com.mapper.OuterLinkMapper;
import com.model.OuterLink;
import com.service.OuterLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("outerLinkService")
public class OuterLinkServiceImpl extends BaseService<OuterLink> implements OuterLinkService {

	@Autowired
	private OuterLinkMapper outerLinkMapper;

	@Override
	public List<OuterLink> getList(OuterLink outerLink) {
		return outerLinkMapper.getList(outerLink);
	}
}
