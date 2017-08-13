/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusflausino.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vanderlei
 */

public class AnswerDAO extends AbstractDAO{   
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        if(this.entityManager == null){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testerHPU");
            this.entityManager = entityManagerFactory.createEntityManager();
        }
        return this.entityManager;
    }

    public AnswerDAO() {
        super(AnswerDAO.class);
    }
}
