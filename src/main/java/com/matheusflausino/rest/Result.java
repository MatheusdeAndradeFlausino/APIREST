/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusflausino.rest;

import com.matheusflausino.dao.QuestionDAO;
import com.matheusflausino.dao.ResultDAO;
import com.matheusflausino.models.Results;
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
@Path("result")
public class Result {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Results> getAll() {
        return new ResultDAO().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Results get(@PathParam("id") Long id) {
        return (Results) new ResultDAO().find(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Results result) {
        new ResultDAO().create(result);
        return Response.status(200).entity("Cadastro realizado com sucesso.").build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(Results result) {
        new ResultDAO().edit(result);
        return Response.status(200).entity("Alteração realizada com sucesso.").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Long id) {
        new ResultDAO().remove(id);
        return Response.status(200).entity("Remoção realizada com sucesso.").build();
    }
    
}
