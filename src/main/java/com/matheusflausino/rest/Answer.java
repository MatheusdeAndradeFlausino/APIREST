/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusflausino.rest;

import com.matheusflausino.dao.AnswerDAO;
import com.matheusflausino.models.Answers;
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
@Path("answer")
public class Answer {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Answers> getAll() {
        return new AnswerDAO().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Answers get(@PathParam("id") Long id) {
        return (Answers) new AnswerDAO().find(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Answer answer) {
        new AnswerDAO().create(answer);
        return Response.status(200).entity("Cadastro realizado com sucesso.").build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(Answer answer) {
        new AnswerDAO().edit(answer);
        return Response.status(200).entity("Alteração realizada com sucesso.").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Long id) {
        new AnswerDAO().remove(id);
        return Response.status(200).entity("Remoção realizada com sucesso.").build();
    }

}
