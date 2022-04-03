package com.redline.ecoredlinekgback.mapper;

import com.redline.ecoredlinekgback.pojo.Instance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {
    Instance[] getInstanceArr();
    Instance[] getInstanceArr(int num);
}
