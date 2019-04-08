package com.mapper;

import com.model.Information;
import com.util.MyMapper;

public interface InformationMapper extends MyMapper<Information> {
    void updateInformation(Information information);

    Information getInfomation();

    Information getAboutUs();

    Information getCallUs();

    Information getLegalStatement();
}
