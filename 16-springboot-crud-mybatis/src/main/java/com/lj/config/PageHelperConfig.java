package com.lj.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper() {
        PageHelper page = new PageHelper();
        Properties params = new Properties();
        params.setProperty("offsetAsPageNum", "true");
        params.setProperty("rowBoundsWithCount", "true");
        params.setProperty("reasonable", "true");
        page.setProperties(params);
        return  page;
    }
}
