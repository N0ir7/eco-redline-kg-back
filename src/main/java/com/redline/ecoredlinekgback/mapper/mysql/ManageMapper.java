package com.redline.ecoredlinekgback.mapper.mysql;

import com.redline.ecoredlinekgback.pojo.Instance;
import com.redline.ecoredlinekgback.pojo.Node;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManageMapper {
    List<Instance> getInstances(@Param("from") int from,@Param("to") int to,@Param("name") String name);
    int getInstancesNum(@Param("name") String name);
}
