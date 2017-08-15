/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusflausino.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vanderlei
 */
public class Connection {
    private static EntityManagerFactory entityManagerMainFactory;
    
    private Connection(){}
    
    public synchronized static EntityManager getEntityManagerMain(){
        if(Connection.entityManagerMainFactory == null){
            Connection.entityManagerMainFactory = Persistence.createEntityManagerFactory("testerHPU");
        }
        return Connection.entityManagerMainFactory.createEntityManager();        
    }
    
}
