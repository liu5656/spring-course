package com.lj.service.impl;

import com.lj.mapper.HeroMapper;
import com.lj.pojo.Hero;
import com.lj.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired HeroMapper mapper;

    @Override
    public int add(Hero hero) {
        return mapper.add(hero);
    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
    }

    @Override
    public Hero get(int id) {
        return mapper.get(id);
    }

    @Override
    public int update(Hero hero) {
        return mapper.update(hero);
    }

    @Override
    public List<Hero> list() {
        return mapper.list();
    }
}
