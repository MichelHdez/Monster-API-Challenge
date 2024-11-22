package com.monster.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monster.dto.MonsterDTO;
import com.monster.exception.ResourceNotFoundException;
import com.monster.services.MonsterService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1")
public class MonsterController {

    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping("/monsters")
    public List<MonsterDTO> listarMontruos() {
        return monsterService.listMonster();
    }

    @GetMapping("/monsters/{id}")
    public MonsterDTO obtenerPorId(@PathVariable Long id) throws ResourceNotFoundException{
        return monsterService.getMonster(id);
    }

    @PostMapping("/monsters")
    public MonsterDTO guardarMonstruo(@RequestBody MonsterDTO monsterDTO) {        
        return monsterService.saveMonster(monsterDTO);
    }

    @PutMapping("monsters/{id}")
    public MonsterDTO actualizarMonstruo(@PathVariable Long id, @RequestBody MonsterDTO monsterDTO) {
        monsterDTO.setId(id);
        return monsterService.updateMonster(id, monsterDTO);
    }
    
    @DeleteMapping("/monsters/{id}")
    public void eliminarMonstruo(@PathVariable Long id){
        monsterService.deleteMonster(id);
    }
}
