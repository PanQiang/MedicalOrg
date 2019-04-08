package com.service;

import com.model.OuterLink;

import java.util.List;

public interface OuterLinkService extends IService<OuterLink> {

    List<OuterLink> getList(OuterLink outerLink);
}
