package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.entity.DemoEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper extends BaseMapper<DemoEntity> {

    @Select("SELECT * FROM demo WHERE name = #{name}")
    List<DemoEntity> listByName(String name);
}
