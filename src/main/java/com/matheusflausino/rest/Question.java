/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusflausino.rest;

import com.matheusflausino.dao.QuestionDAO;
import com.matheusflausino.models.Questions;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author vanderlei
 */
@Path("question")
public class Question {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Questions> getAll() {
        return new QuestionDAO().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Questions get(@PathParam("id") Long id) {
        return (Questions) new QuestionDAO().find(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Questions question) {
        new QuestionDAO().create(question);
        return Response.status(200).entity("Cadastro realizado com sucesso.").build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(Questions question) {
        new QuestionDAO().edit(question);
        return Response.status(200).entity("Alteração realizada com sucesso.").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Long id) {
        new QuestionDAO().remove(id);
        return Response.status(200).entity("Remoção realizada com sucesso.").build();
    }
    
}
