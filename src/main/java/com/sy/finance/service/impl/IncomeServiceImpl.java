package com.sy.finance.service.impl;

import com.sy.finance.domain.IncomeDetail;
import com.sy.finance.domain.dto.AddIncomeInfoDto;
import com.sy.finance.redis.RedisUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.finance.mapper.IncomeMapper;
import com.sy.finance.domain.Income;
import com.sy.finance.service.IncomeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Resource
    private IncomeMapper incomeMapper;


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
        Income income = addIncomeInfoDto.getIncome();
        income.setCreated(new Date());
        income.setSerialUmber(getSeriNum());
        int insert = insert(income);
        List<IncomeDetail> incomeDetailList = addIncomeInfoDto.getIncomeDetailList();
        for (IncomeDetail detail : incomeDetailList){
            detail.setParentId(income.getId());
        }
        return 0;
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
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date();
        String mmStr = mm.format(date);
        String dfStr = df.format(date);
        Object o = redisUtil.get("seriNum::" + mmStr);
        if (o!=null){
            Integer i = Integer.parseInt(o.toString())+1;
            String s = fillLen(i+"");
            return dfStr+s;
        }
        redisUtil.set("seriNum::",1);
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
