package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.model.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long>{

}
