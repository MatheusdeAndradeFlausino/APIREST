/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusflausino.test;

import com.matheusflausino.models.Answers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vanderlei
 */
public class Test {
    private final EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Test() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testerHPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void main(String[] args) {
        Test t = new Test();
        Answers a = t.getEntityManager().find(Answers.class, 1l);
        System.out.println(a.getDescription());
    }
}
