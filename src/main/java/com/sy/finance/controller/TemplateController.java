package com.sy.finance.controller;

import com.sy.finance.domain.Template;
import com.sy.finance.service.TemplateService;
import com.sy.finance.utils.OssUtil;
import com.sy.finance.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import java.util.List;

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
    @ApiOperation(value = "根据收入id打印模版")
    public RespBean templateFill(@RequestParam(value = "id") Integer id){
        return RespBean.succeed(templateService.templateFill(id));
    }

    @GetMapping("/upload")
    @ApiOperation(value = "文件上传")
    public RespBean fileUpload(MultipartFile file){
        String test = OssUtil.upload(file, "test");
        return RespBean.succeed(test);
    }


    @PostMapping("/updTemplateInfo")
    @ApiOperation(value = "修改模版信息")
    public RespBean updTemplateInfo(@RequestBody Template template){
        templateService.updateByPrimaryKeySelective(template);
        return RespBean.succeed();
    }



    @GetMapping("/getTemplateList")
    @ApiOperation(value = "获取模版列表")
    public RespBean<List<Template>> getTemplateList(){
        List<Template> templates = templateService.selectByAll(null);
        return RespBean.succeed(templates);
    }

    @PostMapping("/addTemplateInfo")
    @ApiOperation(value = "添加模版信息")
    public RespBean addTemplateInfo(@RequestBody Template template){
        templateService.insert(template);
        return RespBean.succeed();
    }



}
