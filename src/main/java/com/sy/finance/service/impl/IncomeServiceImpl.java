package com.sy.finance.service.impl;

import com.sy.finance.domain.IncomeDetail;
import com.sy.finance.domain.dto.AddIncomeInfoDto;
import com.sy.finance.redis.RedisUtil;
import com.sy.finance.service.IncomeDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.finance.mapper.IncomeMapper;
import com.sy.finance.domain.Income;
import com.sy.finance.service.IncomeService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Resource
    private IncomeMapper incomeMapper;

    @Resource
    private IncomeDetailService incomeDetailService;


    @Resource
    private RedisUtil redisUtil;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return incomeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Income record) {
        return incomeMapper.insert(record);
    }

    @Override
    public int insertSelective(Income record) {
        return incomeMapper.insertSelective(record);
    }

    @Override
    public Income selectByPrimaryKey(Integer id) {
        return incomeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Income record) {
        return incomeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Income record) {
        return incomeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Income> selectByAll(Income income) {
        return incomeMapper.selectByAll(income);
    }




    @Override
    public int addIncome(AddIncomeInfoDto addIncomeInfoDto) {
        BigDecimal total = new BigDecimal("0");
        List<IncomeDetail> incomeDetailList = addIncomeInfoDto.getIncomeDetailList();
        for (IncomeDetail detail : incomeDetailList) {
            BigDecimal multiply = detail.getPrice().multiply(new BigDecimal(detail.getCount()));
            detail.setPrices(multiply.setScale(2, BigDecimal.ROUND_HALF_UP));
            total =  total.add(multiply).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        Income income = new Income();
        BeanUtils.copyProperties(addIncomeInfoDto,income);
        income.setCreated(new Date());
        income.setSerialUmber(getSeriNum());
        income.setTotalMoney(total);
        income.setStatus(1);
        income.setClearing(0);
        int insert = insert(income);
        ArrayList<IncomeDetail> incomeDetails = new ArrayList<>();
        for (IncomeDetail detail : incomeDetailList){
            detail.setParentId(income.getId());
            incomeDetails.add(detail);
        }
        int i = incomeDetailService.insertList(incomeDetails);
        return 0;
    }

    @Override
    public void updIncomeInfoById(AddIncomeInfoDto income) {
        BigDecimal total = new BigDecimal("0");
        List<IncomeDetail> incomeDetailList = income.getIncomeDetailList();
        ArrayList<IncomeDetail> incomeDetails = new ArrayList<>();
        for (IncomeDetail detail : incomeDetailList) {
            BigDecimal multiply = detail.getPrice().multiply(new BigDecimal(detail.getCount()));
            detail.setPrices(multiply.setScale(2, BigDecimal.ROUND_HALF_UP));
            total =  total.add(multiply).setScale(2, BigDecimal.ROUND_HALF_UP);
            if(detail.getId()==null||detail.getId()==0){
                incomeDetails.add(detail);
                continue;
            }
            incomeDetailService.updateByPrimaryKeySelective(detail);
        }
        Income incomes = new Income();
        BeanUtils.copyProperties(income,incomes);
        income.setTotalMoney(total);
        int insert = updateByPrimaryKeySelective(incomes);
        for (IncomeDetail detail : incomeDetailList){
            detail.setParentId(income.getId());
        }
        incomeDetailService.insertList(incomeDetails);




    }

    @Override
    public int updateStatusById(Integer id, Integer status) {
        return incomeMapper.updateStatusById(id,status);
    }

    @Override
    public int updateClearingById(Integer id, Integer clearing) {
        return incomeMapper.updateClearingById(id,clearing);
    }




    /**
     * 获取流水号
     * @return
     */
    private String getSeriNum(){
        SimpleDateFormat mm = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
        Date date = new Date();
        String mmStr = mm.format(date);
        String dfStr = df.format(date);
        Object o = redisUtil.get("seriNum::" + mmStr);
        if (o!=null){
            Integer i = Integer.parseInt(o.toString())+1;
            String s = fillLen(i+"");
            redisUtil.set("seriNum::" + mmStr,i);
            return dfStr+s;
        }
        redisUtil.set("seriNum::" + mmStr,1);
        return dfStr+"0001";

    }

    private static String fillLen(String str){
        for (int i=str.length(); i<4;i++){
            str = "0"+str;
        }
        return str;

    }

    public static void main(String[] args) {
        String s = fillLen("334");
        System.out.println(s);

    }

}
