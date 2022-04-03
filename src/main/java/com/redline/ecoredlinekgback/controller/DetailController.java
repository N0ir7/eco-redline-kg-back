package com.redline.ecoredlinekgback.controller;

import com.redline.ecoredlinekgback.service.DetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class DetailController {
    @Autowired
    DetailService detailService;

    @RequestMapping("/detail")
    public String graphDataByInId(@RequestParam(value = "inId",required = false) Integer inId,@RequestParam(value = "nodeId",required = false) Integer nodeId) throws IOException {
        log.info("图谱查询inId="+inId);
        log.info("图谱查询nodeId="+nodeId);
        return detailService.getGraph(nodeId,inId);
    }
}
