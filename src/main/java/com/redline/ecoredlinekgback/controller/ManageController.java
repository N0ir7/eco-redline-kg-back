package com.redline.ecoredlinekgback.controller;

import com.redline.ecoredlinekgback.dto.InstanceInfo;
import com.redline.ecoredlinekgback.dto.NodeInfo;
import com.redline.ecoredlinekgback.service.ManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
@Api(value = "知识管理", tags = "知识管理相关接口")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/getInstance")
    @ApiOperation(value = "获取实例信息",notes = "支持分页功能与模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo",value = "页号",defaultValue = "1"),
            @ApiImplicitParam(name="pageSize",value = "页大小",defaultValue = "4"),
            @ApiImplicitParam(name="name",value = "搜索词")
    })
    public InstanceInfo getInstance(@RequestParam(name = "pageNo",defaultValue = "1",required = false) int pageNo,
                                    @RequestParam(name = "pageSize",defaultValue = "4",required = false) int pageSize,
                                    @RequestParam(name = "name",required = false) String name){

        return manageService.getInstanceInfo(pageNo,pageSize,name);
    }

    @GetMapping("/getNodes")
    @ApiOperation(value = "获取节点信息",notes = "支持分页功能与模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo",value = "页号",defaultValue = "1"),
            @ApiImplicitParam(name="pageSize",value = "页大小",defaultValue = "4"),
            @ApiImplicitParam(name="name",value = "搜索词")
    })
    public NodeInfo getNodes(@RequestParam(name = "pageNo",defaultValue = "1",required = false) int pageNo,
                             @RequestParam(name = "pageSize",defaultValue = "4",required = false) int pageSize,
                             @RequestParam(name = "name",required = false) String name){

        return manageService.getNodes(pageNo,pageSize,name);
    }
}
