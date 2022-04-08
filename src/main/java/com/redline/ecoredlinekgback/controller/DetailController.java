package com.redline.ecoredlinekgback.controller;

import com.redline.ecoredlinekgback.dto.GraphInfo;
import com.redline.ecoredlinekgback.service.DetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/detail")
@Api(value = "图谱数据查询", tags = "图谱查询相关接口")
public class DetailController {
    @Autowired
    DetailService detailService;

    @GetMapping("/getGraph")
    @ApiOperation(value = "获取节点或者实例的图谱",notes = "实例id或节点id至少得传一个")
    @ApiImplicitParams({
            @ApiImplicitParam(name="inId",value = "实例id"),
            @ApiImplicitParam(name="nodeId",value = "节点id"),
    })
    public GraphInfo graphDataByInId(@RequestParam(value = "inId",required = false) Integer inId, @RequestParam(value = "nodeId",required = false) Integer nodeId) throws IOException {
        log.info("图谱查询inId="+inId);
        log.info("图谱查询nodeId="+nodeId);
        return detailService.getGraph(nodeId,inId);
    }
}
