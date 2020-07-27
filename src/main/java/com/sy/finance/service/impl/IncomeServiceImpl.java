package com.sy.finance.service.impl;

import com.sy.finance.domain.IncomeDetail;
import com.sy.finance.domain.dto.AddIncomeInfoDto;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.finance.mapper.IncomeMapper;
import com.sy.finance.domain.Income;
import com.sy.finance.service.IncomeService;

import java.util.Date;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Resource
    private IncomeMapper incomeMapper;

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

}
