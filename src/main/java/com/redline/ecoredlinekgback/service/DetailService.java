package com.redline.ecoredlinekgback.service;

import com.redline.ecoredlinekgback.exception.ServiceException;
import com.redline.ecoredlinekgback.mapper.DetailMapper;
import com.redline.ecoredlinekgback.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class DetailService {
    @Autowired
    DetailMapper detailMapper;

    public String getGraph(Integer nodeId,Integer inId) throws IOException {
        if(inId!=null){
            String graphName = detailMapper.getGraphNameByInstanceId(inId);
            return readJSONFile(graphName);
        }else if(nodeId!=null){

        }else {
            throw new ServiceException(ResultCode.INVALID_GRAPH_QUERY);
        }
        return "";
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
