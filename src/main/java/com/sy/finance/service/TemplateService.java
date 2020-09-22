package com.sy.finance.service;

import com.sy.finance.domain.Template;

import java.util.List;

/**
 * @author sy
 * @date Created in 2020.7.28 21:42
 * @description
 */
public interface TemplateService {

    String templateFill(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);

    List<Template> selectByAll(Template template);


    /**
     * 获取最合适的模版
     * @param line
     * @return
     */
    Template  getSuitableByLine(Integer line);
}

