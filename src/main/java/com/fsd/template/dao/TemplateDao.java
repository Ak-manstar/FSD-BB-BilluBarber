package com.fsd.template.dao;

import com.fsd.template.entity.TemplateEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TemplateDao {

    //methods to declare crud operations

    List<TemplateEntity> getdata();
}
