package com.lj.web;

import com.lj.dao.CategoryDAO;
import com.lj.pojo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired CategoryDAO dao;

    @RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception {
        List<Category> cs = dao.findAll();
        System.out.println("-------------------test");
        m.addAttribute("cs", cs);
        return "listCategory";
    }
}
