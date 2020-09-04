package com.sy.finance.service.impl;

import com.sy.finance.domain.Income;
import com.sy.finance.domain.IncomeDetail;
import com.sy.finance.domain.Template;
import com.sy.finance.mapper.TemplateMapper;
import com.sy.finance.service.IncomeDetailService;
import com.sy.finance.service.IncomeService;
import com.sy.finance.service.TemplateService;
import com.sy.finance.utils.OssUtil;
import com.sy.finance.utils.PDFUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    @Resource
    private TemplateMapper templateMapper;


    @Override
    public String templateFill(Integer id) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Income income = incomeService.selectByPrimaryKey(id);
        List<IncomeDetail> incomeDetails = incomeDetailService.selectByParentId(id);

        HashMap<String, Object> map = new HashMap<>();

        map.put("client", income.getClientName());
        map.put("phone", income.getPhone());
        map.put("staff", income.getOperator());
        map.put("time", df.format(new Date()));
        map.put("serialNum", income.getSerialUmber());
        map.put("total", income.getTotalMoney());

        for (int i = 1; i <= incomeDetails.size(); i++) {
            map.put("number" + i, fillLen(i+""));
            map.put("brandName" + i, incomeDetails.get(i - 1).getGoodsName());
            map.put("price" + i, incomeDetails.get(i - 1).getPrice());
            map.put("quantity" + i, incomeDetails.get(i - 1).getCount());
            map.put("prices" + i, incomeDetails.get(i - 1).getPrices());
        }

        String fileUrl;
        if (incomeDetails.size() <= 6) {
            Template template = selectByPrimaryKey(1);
            fileUrl=template.getFileUrl();
        } else if (incomeDetails.size() <= 10) {
            Template template = selectByPrimaryKey(2);
            fileUrl=template.getFileUrl();
        } else if (incomeDetails.size() <= 14) {
            Template template = selectByPrimaryKey(3);
            fileUrl=template.getFileUrl();
        } else {
            Template template = selectByPrimaryKey(4);
            fileUrl=template.getFileUrl();
        }
        InputStream inputStream = PDFUtil.convertTransData(map, fileUrl);
        String pdf = OssUtil.getFileNameBySuffix("pdf");
        String s = OssUtil.uploadByStream(inputStream, null, pdf);
        return s;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return templateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Template record) {
        return templateMapper.insert(record);
    }

    @Override
    public int insertSelective(Template record) {
        return templateMapper.insertSelective(record);
    }

    @Override
    public Template selectByPrimaryKey(Integer id) {
        return templateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Template record) {
        return templateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Template record) {
        return templateMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Template> selectByAll(Template template) {
        return templateMapper.selectByAll(template);
    }


    public String fillLen(String str){
        if (str.length()<2){
            return "0"+str;
        }
        return str;

    }
}

