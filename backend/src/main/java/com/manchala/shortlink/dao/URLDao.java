package com.manchala.shortlink.dao;

import com.manchala.shortlink.entity.URLEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = URLEntity.class, idClass = Long.class)
@Transactional
public interface URLDao {

    public URLEntity save(URLEntity longUrlEntity);

    @Modifying
    @Query("UPDATE URLEntity url SET url.noOfClicks = url.noOfClicks + 1 WHERE url.id = :id")
    public Integer incrementClickCount(Long id);

    public URLEntity findById(Long id);
    public List<URLEntity> findAll();
}