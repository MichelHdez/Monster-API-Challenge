package com.monster.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.monster.dto.MonsterDTO;
import com.monster.model.Monster;

@Service
public class MonsterMapper {

    public MonsterDTO mapMonster(Monster monster){
        MonsterDTO monsterDTO = new MonsterDTO();
        BeanUtils.copyProperties(monster, monsterDTO);
        return monsterDTO;
    }

    public Monster mapMonsterDTO(MonsterDTO monsterDTO){
        Monster monster = new Monster();
        BeanUtils.copyProperties(monsterDTO, monster);
        return monster;
    }

}
