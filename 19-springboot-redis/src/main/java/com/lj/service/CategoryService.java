package com.lj.service;

import org.springframework.data.domain.Pageable;

import com.lj.pojo.Category;
import com.lj.util.Page4Navigator;

public interface CategoryService {

    public Page4Navigator<Category> list(Pageable pageable);

    public void save(Category category);

    public void delete(int id);

    public Category get(int id);
}