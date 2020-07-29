package com.sy.finance.service.impl;

import com.sy.finance.domain.Income;
import com.sy.finance.domain.IncomeDetail;
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


    @Override
    public String templateFill(Integer id) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Income income = incomeService.selectByPrimaryKey(id);
        List<IncomeDetail> incomeDetails = incomeDetailService.selectByParentId(id);

        HashMap<String, Object> map = new HashMap<>();

        map.put("client",income.getClientName());
        map.put("phone",income.getPhone());
        map.put("staff","李锐明");
        map.put("time",df.format(new Date()));
        map.put("serialNum",income.getSerialUmber());
        map.put("total",income.getTotalMoney());

        for (int i = 1; i <= incomeDetails.size(); i++) {
            map.put("number"+i,i);
            map.put("brandName"+i,incomeDetails.get(i-1).getGoodsName());
            map.put("price"+i,incomeDetails.get(i-1).getPrice());
            map.put("quantity"+i,incomeDetails.get(i-1).getCount());
            map.put("prices"+i,incomeDetails.get(i-1).getPrices());
        }

        String fileUrl = "/static/file";
        if (incomeDetails.size()<=7){
            fileUrl = "http://eecontract.oss-cn-beijing.aliyuncs.com/test/20200729221906prXozOSJURF7sFZ.pdf";
        }else if (incomeDetails.size()<=14){
            fileUrl = fileUrl+"2.pdf";
        }else if (incomeDetails.size()<=21){
            fileUrl = fileUrl+"4.pdf";
        }else{
            fileUrl = fileUrl+"5.pdf";
        }
        InputStream inputStream = PDFUtil.convertTransData(map, fileUrl);
        String pdf = OssUtil.getFileNameBySuffix("pdf");
        String s = OssUtil.uploadByStream(inputStream, null, pdf);
        return s;
    }
}
