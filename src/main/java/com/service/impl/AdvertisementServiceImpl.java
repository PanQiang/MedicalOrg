package com.service.impl;
import com.mapper.AdvertisementMapper;
import com.model.Advertisement;
import com.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("advertisementService")
public class AdvertisementServiceImpl extends BaseService<Advertisement> implements AdvertisementService {

	@Autowired
	private AdvertisementMapper advertisementMapper;


	@Override
	public List<Advertisement> indexAdvertisement(Advertisement advertisement) {

		List<Advertisement> list = advertisementMapper.indexAdvertisement(advertisement);
		return list;
	}
}
