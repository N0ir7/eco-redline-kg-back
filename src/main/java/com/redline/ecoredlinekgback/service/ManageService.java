package com.redline.ecoredlinekgback.service;

import com.redline.ecoredlinekgback.dto.InstanceInfo;
import com.redline.ecoredlinekgback.dto.NodeInfo;
import com.redline.ecoredlinekgback.exception.ServiceException;
import com.redline.ecoredlinekgback.mapper.mysql.ManageMapper;
import com.redline.ecoredlinekgback.mapper.neo4j.ManageNeo4jMapper;
import com.redline.ecoredlinekgback.pojo.Instance;
import com.redline.ecoredlinekgback.pojo.Node;
import com.redline.ecoredlinekgback.utils.UrlUtil;
import com.redline.ecoredlinekgback.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageService {
    @Autowired
    ManageMapper manageMapper;
    @Autowired
    ManageNeo4jMapper manageNeo4jMapper;
    public InstanceInfo getInstanceInfo(int pageNo, int pageSize, String name){
        int from = (pageNo-1)*pageSize;
        int to = pageNo*pageSize;
        if(name!=null){
            name = String.join("%",name.split(""));
            name = "%"+name+"%";
        }
        int instancesNum = manageMapper.getInstancesNum(name);

        if(from>instancesNum||from<0){
            throw new ServiceException(ResultCode.OUT_OF_DATABASE_BOUND);
        }

        List<Instance> instances = manageMapper.getInstances(from,to,name);

        return new InstanceInfo(instances,instancesNum);
    }

    public NodeInfo getNodes(int pageNo, int pageSize, String name) {
        int from = (pageNo-1)*pageSize;
//        if(name!=null){
//            name = String.join("%",name.split(""));
//            name = "%"+name+"%";
//        }
        int nodesNum = manageNeo4jMapper.getNodesNum(name);

        if(from>nodesNum||from<0){
            throw new ServiceException(ResultCode.OUT_OF_DATABASE_BOUND);
        }

        List<Node> nodes = manageNeo4jMapper.getNodes(from,pageSize,name);
        for (Node node : nodes) {
            node.setImgUrl(UrlUtil.convertImgUrl(node.getImgUrl()));
        }
        System.out.println(nodes);
        return new NodeInfo(nodes,nodesNum);
    }

}
