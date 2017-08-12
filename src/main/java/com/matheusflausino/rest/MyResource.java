package com.matheusflausino.rest;

import com.matheusflausino.dao.AnswerDAO;
import com.matheusflausino.models.Answers;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.persistence.EntityManager;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testerHPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Answers resposta = entityManager.find(Answers.class, 1l);
        return resposta.getDescription();

    }
}
