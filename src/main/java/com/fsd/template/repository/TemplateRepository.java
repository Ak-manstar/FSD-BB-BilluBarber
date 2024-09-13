package com.fsd.template.repository;

import com.fsd.template.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<TemplateEntity,Long> {
}
