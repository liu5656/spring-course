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

@Controller
public class CategoryController {
    @Autowired CategoryDAO dao;

    @PostMapping("/categories")
    public String addCategory(Category c) throws Exception {
        dao.save(c);
        return "redirect:/categories";
    }
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
        dao.delete(c);
        return "redirect:/categories";
    }
    @PutMapping("/categories/{id}}")
    public String updateCategory(Category c) throws Exception {
        dao.save(c);
        return "redirect:/categories";
    }
    @GetMapping("/categories/{id}")
    public String getCategory(@PathVariable("id") int id, Model m) throws Exception {
        Category c = dao.getOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }

    @GetMapping("/categories")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page =dao.findAll(pageable);

        System.out.println(page.getContent());


        m.addAttribute("page", page);

        return "listCategory";

    }


}
