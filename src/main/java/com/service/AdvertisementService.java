package com.service;

import com.model.Advertisement;

import java.util.List;

public interface AdvertisementService extends IService<Advertisement> {
    List<Advertisement> indexAdvertisement(Advertisement advertisement);
}
