package com.monster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monster.dto.MonsterDTO;

@Service
public interface MonsterService {

    // Listamos todos
    List<MonsterDTO> listMonster();

    //Guardamos un monstruo
    MonsterDTO saveMonster(MonsterDTO MonsterDTO);

    //Obtenemos un monstruo por Id
    MonsterDTO getMonster(Long Id);

    //Actualizamos datos de un monstruo
    MonsterDTO updateMonster(Long Id, MonsterDTO MonsterDTO);

    //Eliminamos a un monstruo
    void deleteMonster(Long Id);

}
