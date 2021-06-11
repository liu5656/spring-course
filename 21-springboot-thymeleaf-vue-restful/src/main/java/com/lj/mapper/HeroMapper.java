package com.lj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.lj.pojo.Hero;

import java.util.List;

@Mapper
public interface HeroMapper {
    public int add(Hero hero);
    public void delete(int id);
    public Hero get(int id);
    public int update(Hero hero);
    public List<Hero> list();
}
