package com.example.demo.entity;

import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.util.List;

@Entity
public class Entity2 {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "entity1_id", referencedColumnName = "id")
    private Entity1 entity1;

    @OneToMany(mappedBy = "entity2")
    private List<Entity3> entity3List;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Entity1 getEntity1() {
        return entity1;
    }

    public void setEntity1(Entity1 entity1) {
        this.entity1 = entity1;
    }

    public List<Entity3> getEntity3List() {
        return entity3List;
    }

    public void setEntity3List(List<Entity3> entity3List) {
        this.entity3List = entity3List;
    }
}