package com.lj.web;

import com.lj.mapper.CategoryMapper;
import com.lj.pojo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired CategoryMapper mapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception {
        List<Category> cs = mapper.findAll();
        System.out.println("-------------------test");
        m.addAttribute("cs", cs);
        return "listCategory";
    }
}
