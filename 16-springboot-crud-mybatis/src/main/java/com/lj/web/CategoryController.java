package com.lj.web;

import com.github.pagehelper.PageInfo;
import com.lj.mapper.CategoryMapper;
import com.lj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired CategoryMapper dao;

//    @RequestMapping("/listCategory")
//    public String listCategory(Model m) throws Exception {
//        List<Category> cs = dao.findAll();
//        System.out.println("-------------------test");
//        m.addAttribute("cs", cs);
//        return "listCategory";
//    }

    @RequestMapping("/addCategory")
    public String addCategory(Category c) throws Exception {
        dao.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        dao.delete(c.getId());
        return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        dao.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String editCategory(int id, Model m) throws Exception {
        Category c = dao.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }

    @RequestMapping("/listCategory")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Category> cs = dao.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page", page);

        return "listCategory";
    }


}
