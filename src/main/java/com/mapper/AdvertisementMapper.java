package com.mapper;

import com.model.Advertisement;
import com.util.MyMapper;
import java.util.List;

public interface AdvertisementMapper extends MyMapper<Advertisement>{

    List<Advertisement> indexAdvertisement(Advertisement advertisement);
}
