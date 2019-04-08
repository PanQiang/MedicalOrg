package com.mapper;

import com.model.OuterLink;
import com.util.MyMapper;
import java.util.List;

public interface OuterLinkMapper extends MyMapper<OuterLink> {

    List<OuterLink> getList(OuterLink outerLink);
}
