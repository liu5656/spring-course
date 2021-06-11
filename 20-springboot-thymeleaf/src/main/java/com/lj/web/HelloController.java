package com.lj.web;

import com.lj.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model m){
        m.addAttribute("name", "thymeleaf");
        return "hello";
    }

    @RequestMapping("/test")
    public String test(Model m) {
        String htmlContent = "<p style='color:red'>红色文字</p>";
        Product product = new Product(5, "product e", 200);
        m.addAttribute("htmlContent", htmlContent);
        m.addAttribute("currentProduct", product);
        m.addAttribute("testBoolean", true);

        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 200));
        ps.add(new Product(2,"product b", 200));
        ps.add(new Product(3,"product c", 200));
        ps.add(new Product(4,"product d", 200));
        ps.add(new Product(5,"product e", 200));
        ps.add(new Product(6,"product f", 200));

        m.addAttribute("ps", ps);

        m.addAttribute("now", new Date());

        return "test";
    }
}
