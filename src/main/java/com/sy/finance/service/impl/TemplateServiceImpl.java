package com.sy.finance.service.impl;

import com.sy.finance.domain.Income;
import com.sy.finance.domain.IncomeDetail;
import com.sy.finance.service.IncomeDetailService;
import com.sy.finance.service.IncomeService;
import com.sy.finance.service.TemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.7.28 21:43
 * @description
 */
@Service
public class TemplateServiceImpl implements TemplateService {



    @Resource
    private IncomeDetailService incomeDetailService;

    @Resource
    private IncomeService incomeService;


    @Override
    public String templateFill(Integer id) {
        Income income = incomeService.selectByPrimaryKey(id);
        List<IncomeDetail> incomeDetails = incomeDetailService.selectByParentId(id);


        return null;
    }
}
