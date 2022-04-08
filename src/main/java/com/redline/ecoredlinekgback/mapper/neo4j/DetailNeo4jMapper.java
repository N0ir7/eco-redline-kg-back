package com.redline.ecoredlinekgback.mapper.neo4j;

import com.redline.ecoredlinekgback.pojo.Link;
import com.redline.ecoredlinekgback.pojo.Node;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailNeo4jMapper {

    Node getGraphNodesByNodeId(int nId);
    List<Node> getGraphTargetNodesBySourceNodeId(int nId);
    List<Link> getGraphLinksBySourceNodeId(int nId);

}
