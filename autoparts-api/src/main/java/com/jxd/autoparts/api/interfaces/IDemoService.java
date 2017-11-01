package com.jxd.autoparts.api.interfaces;

import com.jxd.autoparts.api.pojo.DemoPj;

import java.util.List;

public interface IDemoService {

    DemoPj getDemoPj(String... obj);

    List<DemoPj> getDemoPjList(Integer num);

}
