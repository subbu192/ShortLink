package com.manchala.shortlink.dao;

import com.manchala.shortlink.entity.URLEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = URLEntity.class, idClass = Long.class)
@Transactional
public interface URLDao {

    public URLEntity save(URLEntity longUrlEntity);

    public URLEntity findById(Long id);

    public List<URLEntity> findAll();
}