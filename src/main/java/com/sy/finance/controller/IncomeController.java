package com.sy.finance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.finance.domain.Income;
import com.sy.finance.domain.IncomeDetail;
import com.sy.finance.domain.dto.AddIncomeInfoDto;
import com.sy.finance.domain.dto.GetIncomDetailDto;
import com.sy.finance.domain.dto.GetIncomeDto;
import com.sy.finance.service.IncomeDetailService;
import com.sy.finance.service.IncomeService;
import com.sy.finance.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.7.27 22:04
 * @description 收入处理
 */
@RestController
@RequestMapping("/income")
@Api(tags = "收入")
public class IncomeController {


    @Resource
    private IncomeService incomeService;


    @Resource
    private IncomeDetailService incomeDetailService;


    @PostMapping("/addIncomeInfo")
    @ApiOperation(value = "添加收入信息")
    public RespBean addIncome(@RequestBody  AddIncomeInfoDto addIncomeInfoDto){
        incomeService.addIncome(addIncomeInfoDto);
        return RespBean.succeed("添加成功");
    }


    @PostMapping("/getIncomeList")
    @ApiOperation(value = "获取收入列表")
    public RespBean<List<Income>> getIncomeList(@RequestBody @Valid GetIncomeDto dto){
        Income income = new Income();
        BeanUtils.copyProperties(dto,income);
        PageHelper.startPage(dto.getPage(),dto.getPageSize());
        List<Income> incomes = incomeService.selectByAll(income);
        return  RespBean.succeed(incomes);
    }


    @ApiOperation(value = "修改状态，主键id和status必传")
    @GetMapping("/updIncomeStatus")
    public RespBean updIncomeStatus(@RequestParam(value = "id") Integer id , @RequestParam(value = "status")Integer status){
        incomeService.updateStatusById(id,status);
        return RespBean.succeed();
    }



    @PostMapping("/getIncomeDetailList")
    @ApiOperation(value = "获取收入详情列表")
    public RespBean<PageInfo<List<IncomeDetail>>> getIncomeDetailList(@RequestBody @Valid GetIncomDetailDto dto){
        IncomeDetail detail = new IncomeDetail();
        BeanUtils.copyProperties(dto,detail);
        PageHelper.startPage(dto.getPage(),dto.getPageSize());
        List<IncomeDetail> incomeDetails = incomeDetailService.selectByAll(detail);
        PageInfo<List<IncomeDetail>> listPageInfo = new PageInfo(incomeDetails);
        return RespBean.succeed(listPageInfo);
    }










}
