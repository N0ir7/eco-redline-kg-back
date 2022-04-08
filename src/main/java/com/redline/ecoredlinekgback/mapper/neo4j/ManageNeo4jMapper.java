package com.redline.ecoredlinekgback.mapper.neo4j;

import com.redline.ecoredlinekgback.pojo.Node;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManageNeo4jMapper {
    int getNodesNum(@Param("name") String name);

    List<Node> getNodes(@Param("from") int from, @Param("size") int size, @Param("name") String name);
}
