package com.sy.finance.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.sy.finance.domain.Template;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);

    List<Template> selectByAll(Template template);


    Template getApproachByLine(@Param("line") Integer line);

    Template getMaxLine();

}
