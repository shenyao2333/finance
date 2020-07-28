package com.sy.finance.controller;

import com.sy.finance.service.TemplateService;
import com.sy.finance.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sy
 * @date Created in 2020.7.28 21:22
 * @description
 */
@RestController
@RequestMapping("/template")
@Api(tags = "模版处理")
public class TemplateController {


    @Resource
    private TemplateService templateService;

    @GetMapping("/templateFill")
    @ApiOperation(value = "根据收入id")
    public RespBean templateFill(@RequestParam(value = "id") Integer id){
        templateService.templateFill(id);
        return null;
    }



}