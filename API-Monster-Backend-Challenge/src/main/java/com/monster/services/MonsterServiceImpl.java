package com.monster.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.dto.MonsterDTO;
import com.monster.exception.ResourceNotFoundException;
import com.monster.model.Monster;
import com.monster.repository.MonsterRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    // Convertir Monster a MonsterDTO
    private MonsterDTO convertToDTO(Monster monster) {
        MonsterDTO dto = new MonsterDTO();
        dto.setId(monster.getId());
        dto.setName(monster.getName());
        dto.setType(monster.getType());
        dto.setScareLevel(monster.getScareLevel());
        return dto;
    }

    // Convertir MonsterDTO a Monster
    private Monster convertToEntity(MonsterDTO dto) {
        Monster monster = new Monster();
        monster.setId(dto.getId());
        monster.setName(dto.getName());
        monster.setType(dto.getType());
        monster.setScareLevel(dto.getScareLevel());
        return monster;
    }

    @Override
    public MonsterDTO saveMonster(MonsterDTO monsterDTO) {
        log.info("Guardando un nuevo monstruo");
        Monster monster = convertToEntity(monsterDTO);
        Monster monsterDB = monsterRepository.save(monster);
        return convertToDTO(monsterDB);
    }

    @Override
    public MonsterDTO getMonster(Long Id) {
        log.info("Obteniendo monstruo por Id: " + Id);
        Monster monster = monsterRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("El monstruo no existe"));
        return convertToDTO(monster);
    }

    @Override
    public MonsterDTO updateMonster(Long Id, MonsterDTO monsterDTO) {
        log.info("Actualizando datos del monstruo");
        Monster existingMonster = monsterRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Monster not found with id " + Id));

        existingMonster.setName(monsterDTO.getName());
        existingMonster.setType(monsterDTO.getType());
        existingMonster.setScareLevel(monsterDTO.getScareLevel());

        // Guardar el monstruo actualizado y devolver el DTO
        Monster updatedMonster = monsterRepository.save(existingMonster);
        return convertToDTO(updatedMonster);
    }

    @Override
    public void deleteMonster(Long Id) {
        log.info("Eliminando un monstruo");
        Optional<Monster> monster = monsterRepository.findById(Id);
        if (monster.isPresent()) {
            monsterRepository.deleteById(Id);
        } else {
            throw new RuntimeException("El monstruo no existe");
        }
    }

    @Override
    public List<MonsterDTO> listMonster() {
        return monsterRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}
