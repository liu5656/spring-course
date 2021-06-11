package com.lj.web;

import com.lj.dao.CategoryDAO;
import com.lj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired CategoryDAO dao;

    // json
    @GetMapping("/category")
    public List<Category> listCategory(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page =dao.findAll(pageable);
        System.out.println("----------------------: get many");
        return page.getContent();
    }
    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") int id) throws Exception {
        Category c = dao.getOne(id);
        System.out.println("----------------------: get one");
        return c;
    }
    @PutMapping("/category")
    public void addCategory(@RequestBody Category category) throws Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+category);
    }



}
