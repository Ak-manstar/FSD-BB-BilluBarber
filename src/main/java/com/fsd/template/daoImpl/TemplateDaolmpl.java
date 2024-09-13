package com.fsd.template.daoImpl;

import com.fsd.template.dao.TemplateDao;
import com.fsd.template.entity.TemplateEntity;
import com.fsd.template.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemplateDaolmpl implements TemplateDao {

    @Autowired
    TemplateRepository repository;

    @Override
    public List<TemplateEntity> getdata() {
        return repository.findAll();
    }

    //methods to implement crud operations.
}
