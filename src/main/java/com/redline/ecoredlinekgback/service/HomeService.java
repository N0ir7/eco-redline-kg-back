package com.redline.ecoredlinekgback.service;

import com.redline.ecoredlinekgback.mapper.HomeMapper;
import com.redline.ecoredlinekgback.pojo.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    HomeMapper homeMapper;

    public Instance[] getInstanceArr(Integer num){
        return num==null?homeMapper.getInstanceArr():homeMapper.getInstanceArr(num);
    }
    public Instance[] getInstanceArr(){
        return homeMapper.getInstanceArr();
    }
}
