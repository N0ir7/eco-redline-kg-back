package com.redline.ecoredlinekgback.service;

import com.redline.ecoredlinekgback.dto.GraphInfo;
import com.redline.ecoredlinekgback.exception.ServiceException;
import com.redline.ecoredlinekgback.mapper.mysql.DetailMapper;
import com.redline.ecoredlinekgback.mapper.neo4j.DetailNeo4jMapper;
import com.redline.ecoredlinekgback.pojo.Link;
import com.redline.ecoredlinekgback.pojo.Node;
import com.redline.ecoredlinekgback.utils.JsonUtil;
import com.redline.ecoredlinekgback.utils.UrlUtil;
import com.redline.ecoredlinekgback.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class DetailService {
    @Autowired
    DetailMapper detailMapper;
    @Autowired
    DetailNeo4jMapper detailNeo4jMapper;
    public GraphInfo getGraph(Integer nodeId, Integer inId) throws IOException {
        GraphInfo graphInfo = null;
        if(inId!=null){
            String graphName = detailMapper.getGraphNameByInstanceId(inId);
            graphInfo = JsonUtil.json2Object(readJSONFile(graphName), GraphInfo.class);
        }else if(nodeId!=null){
            Node sourceNode = detailNeo4jMapper.getGraphNodesByNodeId(nodeId);
            List<Node> nodes = detailNeo4jMapper.getGraphTargetNodesBySourceNodeId(nodeId);
            nodes.add(sourceNode);
            List<Link> links = detailNeo4jMapper.getGraphLinksBySourceNodeId(nodeId);
            graphInfo =  new GraphInfo(nodes,links);
        }else {
            throw new ServiceException(ResultCode.INVALID_GRAPH_QUERY);
        }
        for (Node node : graphInfo.getNodes()) {
            node.setImgUrl(UrlUtil.convertImgUrl(node.getImgUrl()));
        }
        return graphInfo;
    }
    private String readJSONFile(String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("/instance/"+fileName+".json");
        InputStreamReader in = new InputStreamReader(classPathResource.getInputStream(), "UTF-8");
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = in.read()) != -1) {
            sb.append((char) ch);
        }
        in.close();
        return sb.toString();
    }
}
