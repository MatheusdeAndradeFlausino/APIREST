/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusflausino.dao;

import com.matheusflausino.models.Questions;
import com.matheusflausino.util.Connection;
import javax.persistence.EntityManager;

/**
 *
 * @author vanderlei
 */
public class QuestionDAO extends AbstractDAO {
    
    @Override
    protected EntityManager getEntityManager() {
        return Connection.getEntityManagerMain();
    }
    
    public QuestionDAO(){
        super(Questions.class);
    }
}
