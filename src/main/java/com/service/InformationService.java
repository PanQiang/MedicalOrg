package com.service;

import com.model.Information;

public interface InformationService extends IService<Information> {
    void addOrUpdateInfo(Information information);

    Information getInfomation();

    Information getAboutUs();

    Information getCallUs();

    Information getLegalStatement();
}
