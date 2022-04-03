package com.redline.ecoredlinekgback.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailMapper {
    String getGraphNameByInstanceId(int inId);
}
