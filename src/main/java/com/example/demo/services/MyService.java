package com.example.demo.services;

import com.example.demo.entity.Entity1;
import com.example.demo.entity.Entity2;
import com.example.demo.entity.Entity3;
import com.example.demo.repository.Entity1Repository;
import com.example.demo.repository.Entity2Repository;
import com.example.demo.repository.Entity3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



    @Service
    public class MyService {
        private final Entity1Repository entity1Repository;
        private final Entity2Repository entity2Repository;
        private final Entity3Repository entity3Repository;

        @Autowired
        public MyService(Entity1Repository entity1Repository, Entity2Repository entity2Repository, Entity3Repository entity3Repository) {
            this.entity1Repository = entity1Repository;
            this.entity2Repository = entity2Repository;
            this.entity3Repository = entity3Repository;
        }

        public void saveEntities() {
            Entity1 entity1 = new Entity1();
            entity1.setName("Entity1 Name");
            entity1Repository.saveAndFlush(entity1);

            Entity2 entity2 = new Entity2();
            entity2.setDescription("Entity2 Description");
            entity2.setEntity1(entity1);
            entity2Repository.saveAndFlush(entity2);

            Entity3 entity3 = new Entity3();
            entity3.setDetails("Entity3 Details");
            entity3.setEntity2(entity2);
            entity3Repository.saveAndFlush(entity3);
        }

        public void retrieveEntities() {
            List<Entity1> entity1List = entity1Repository.findAll();
            List<Entity2> entity2List = entity2Repository.findAll();
            List<Entity3> entity3List = entity3Repository.findAll();

            // Ваш код для роботи з отриманими даними
        }

        public void updateEntities() {
            // Отримання об'єктів для оновлення
            Entity1 entity1 = entity1Repository.findById(1L).orElse(null);
            Entity2 entity2 = entity2Repository.findById(1L).orElse(null);
            Entity3 entity3 = entity3Repository.findById(1L).orElse(null);

            // Оновлення даних
            if (entity1 != null) {
                entity1.setName("Updated Entity1 Name");
                entity1Repository.save(entity1);
            }

            if (entity2 != null) {
                entity2.setDescription("Updated Entity2 Description");
                entity2Repository.save(entity2);
            }

            if (entity3 != null) {
                entity3.setDetails("Updated Entity3 Details");
                entity3Repository.save(entity3);
            }
        }

        public void deleteEntities() {
            // Видалення об'єктів за ідентифікатором
            entity3Repository.deleteById(1L);
        }

    }


//    public void simpleMethod() {
//        System.out.println("Executing simpleMethod");
//    }
//
//    @org.springframework.web.bind.annotation.ResponseBody
//    public String methodWithResponseBody() {
//        System.out.println("Executing methodWithResponseBody");
//        return "Response from methodWithResponseBody";
//    }
//
//    public void methodWithException(String input) {
//        System.out.println("Executing methodWithException with input: " + input);
//        throw new RuntimeException("Exception from methodWithException");
//    }



