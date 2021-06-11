package com.lj.web;

import com.lj.dao.CategoryDAO;
import com.lj.pojo.Category;
import com.lj.service.impl.CategoryServiceImpl;
import com.lj.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired CategoryServiceImpl dao;

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

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page4Navigator<Category> page =dao.list(pageable);

        m.addAttribute("cs", page.getContent());

        return "listCategory";

    }


}
