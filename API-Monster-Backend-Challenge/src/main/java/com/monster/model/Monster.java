package com.monster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monsters")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private int scareLevel;

    public Monster() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScareLevel() {
        return scareLevel;
    }

    public void setScareLevel(int scareLevel) {
        this.scareLevel = scareLevel;
    }

    @Override
    public String toString() {
        return "Monster [id=" + id + ", name=" + name + ", type=" + type + ", scareLevel=" + scareLevel + "]";
    }

}
