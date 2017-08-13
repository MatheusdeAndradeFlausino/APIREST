/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusflausino.rest;

import com.matheusflausino.dao.AnswerDAO;
import com.matheusflausino.models.Answers;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vanderlei
 */
@Path("answer")
public class Answer {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {        
        List<Answers> ans =  new AnswerDAO().findAll();
        return ans.size() + " resultados";
    }

}
