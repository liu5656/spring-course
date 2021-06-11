package com.lj.service.impl;

import com.lj.dao.CategoryDAO;
import com.lj.pojo.Category;
import com.lj.service.CategoryService;
import com.lj.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "category")
public class CategoryServiceImpl implements CategoryService {

    @Autowired CategoryDAO dao;

    @Override
    @Cacheable(key = "'category '+#p0.offset + '-' + #p0.pageSize ")
    public Page4Navigator<Category> list(Pageable pageable) {
        Page<Category> pageFromJPA = dao.findAll(pageable);
        Page4Navigator<Category> page = new Page4Navigator<>(pageFromJPA, 5);
        return page;
    }

    @Override
    @CacheEvict(allEntries = true)
    public void save(Category category) {
        dao.save(category);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void delete(int id) {
        dao.deleteById(id);
    }

    @Override
    @Cacheable(key = "'category ' + #p0")
    public Category get(int id) {
        return dao.findById(id).orElse(null);
    }
}
