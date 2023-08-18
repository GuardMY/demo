package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.pojo.entity.DemoEntity;
import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DemoService extends ServiceImpl<DemoMapper, DemoEntity> {
    public List<String> listMessageByName(String name) {
        List<DemoEntity> demoEntities = this.baseMapper.listByName(name);
        if (demoEntities.isEmpty()) {
            return new ArrayList<>();
        }
        return demoEntities.stream().sorted(Comparator.comparing(DemoEntity::getCreateDate)).map(DemoEntity::getMessage).toList();
    }

    public boolean writeMessage(String name, String message) {
        if (Strings.isNullOrEmpty(name) || Strings.isNullOrEmpty(message)) {
            return false;
        }
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(name);
        demoEntity.setMessage(message);
        this.save(demoEntity);
        return true;
    }

}
