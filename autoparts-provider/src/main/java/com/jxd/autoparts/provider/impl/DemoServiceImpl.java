package com.jxd.autoparts.provider.impl;

import com.jxd.autoparts.api.interfaces.IDemoService;
import com.jxd.autoparts.api.pojo.DemoPj;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("demoService")
public class DemoServiceImpl implements IDemoService {

    @Override
    public DemoPj getDemoPj(String... obj) {
        DemoPj pj = new DemoPj();
        pj.setId(new Date().getTime());
        pj.setName("测试demo");
        for(String o : obj){
            pj.getList().add(o);
        }
        return pj;
    }

    @Override
    public List<DemoPj> getDemoPjList(Integer num) {
        List<DemoPj> list = new ArrayList<DemoPj>();
        for (int i = 0 ; i < num ; i++){
            DemoPj pj = getDemoPj(i+"");
            list.add(pj);
        }
        return list;
    }
}
