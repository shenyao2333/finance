package com.sy.finance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.finance.domain.Income;
import com.sy.finance.domain.IncomeDetail;
import com.sy.finance.domain.dto.AddIncomeInfoDto;
import com.sy.finance.domain.dto.GetIncomDetailDto;
import com.sy.finance.domain.dto.GetIncomeDto;
import com.sy.finance.domain.vo.IncomesVo;
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
@Api(tags = "账单管理")
public class IncomeController {


    @Resource
    private IncomeService incomeService;


    @Resource
    private IncomeDetailService incomeDetailService;


    @PostMapping("/addIncomeInfo")
    @ApiOperation(value = "添加账单信息")
    public RespBean addIncome(@RequestBody  AddIncomeInfoDto addIncomeInfoDto){
        incomeService.addIncome(addIncomeInfoDto);
        return RespBean.succeed("添加成功");
    }

    @PostMapping("/updIncomeInfoById")
    @ApiOperation(value = "批量修改账单信息")
    public RespBean updIncomeInfoById(@RequestBody AddIncomeInfoDto income){
        incomeService.updIncomeInfoById(income);
        return RespBean.succeed();
    }


    @PostMapping("/getIncomeList")
    @ApiOperation(value = "获取账单列表")
    public RespBean<PageInfo<List<Income>>> getIncomeList(@RequestBody @Valid GetIncomeDto dto){
        Income income = new Income();
        BeanUtils.copyProperties(dto,income);
        PageHelper.startPage(dto.getPage(),dto.getPageSize());
        String[] times = dto.getTimes();
        if (times!=null){
            income.setStartTime(times[0]);
            if (times.length>1){
                income.setEndTime(times[1]);
            }
        }
        List<Income> incomes = incomeService.selectByAll(income);
        PageInfo<List<Income>> listPageInfo = new PageInfo(incomes);
        return  RespBean.succeed(listPageInfo);
    }

    @PostMapping("/updIncomeById")
    @ApiOperation(value = "修改账单")
    public RespBean updIncomeById(@RequestBody Income income){
        incomeService.updateByPrimaryKeySelective(income);
        return RespBean.succeed();
    }



    @ApiOperation(value = "修改状态，主键id和status必传")
    @GetMapping("/updIncomeStatus")
    public RespBean updIncomeStatus(@RequestParam(value = "id") Integer id , @RequestParam(value = "status")Integer status){
        incomeService.updateStatusById(id,status);
        return RespBean.succeed();
    }

    @ApiOperation(value = "修改账单结清状态; 0-未结清  1-结清")
    @GetMapping("/updIncomeClearing")
    public RespBean updIncomeClearing(@RequestParam(value = "id") Integer id , @RequestParam(value = "clearing")Integer clearing){
        int i = incomeService.updateClearingById(id,clearing);
        return RespBean.succeed();
    }





    @PostMapping("/getIncomeDetailList")
    @ApiOperation(value = "获取账单详情列表")
    public RespBean<PageInfo<IncomesVo>> getIncomeDetailList(@RequestBody @Valid GetIncomDetailDto dto){
        IncomeDetail detail = new IncomeDetail();
        BeanUtils.copyProperties(dto,detail);
        PageHelper.startPage(dto.getPage(),dto.getPageSize());
        detail.setPrice(null);
        detail.setPrices(null);
        detail.setActualPrice(null);
        detail.setClearing(null);
        List<IncomeDetail> incomeDetails = incomeDetailService.selectByAll(detail);


        Income income = incomeService.selectByPrimaryKey(dto.getParentId());
        IncomesVo incomesVo = new IncomesVo();
        BeanUtils.copyProperties(income,incomesVo);
        incomesVo.setList(incomeDetails);


        PageInfo<IncomesVo> listPageInfo = new PageInfo(incomeDetails);



        return RespBean.succeed(listPageInfo);
    }


    @ApiOperation(value = "删除账单详细信息的记录")
    @GetMapping("/delIncomeDetailById")
    public RespBean delIncomeDetailById(Integer id){
        incomeDetailService.deleteByPrimaryKey(id);
        return RespBean.succeed();
    }



    @ApiOperation(value = "单条修改账单详细信息")
    @PostMapping("/updIncomeDetailById")
    public RespBean updIncomeDetailById(@RequestBody IncomeDetail incomeDetail){
        incomeDetailService.updateByPrimaryKeySelective(incomeDetail);
        return RespBean.succeed();
    }













}
