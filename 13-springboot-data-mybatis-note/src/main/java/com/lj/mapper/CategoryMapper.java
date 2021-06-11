package com.lj.mapper;

import com.lj.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category_")
    List<Category> findAll();
}
