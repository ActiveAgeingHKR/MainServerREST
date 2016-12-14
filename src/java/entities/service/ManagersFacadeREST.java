/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Managers;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
 * @author Chris
 */
@Stateless
@Path("managers")
public class ManagersFacadeREST extends AbstractFacade<Managers> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    public ManagersFacadeREST() {
        super(Managers.class);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Managers find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Managers entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Managers entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @POST
    @Path("login/{username-password}")
    public Response login(@PathParam("username-password") String usernamepassword) {
        System.out.println("Testing: " + usernamepassword);
        String[] splitted = usernamepassword.split("-");
        String userName = splitted[0];
        String Password = splitted[1];
        Query query = em.createNamedQuery("Managers.Login").setParameter("manUsername", userName).setParameter("manPassword", Password);
        List result1 = query.getResultList();
        System.out.println(result1.toString());
        if (!result1.isEmpty()) {
            return Response.status(200).entity("Client authorized").build();
        } else {
            return Response.status(403).entity("Client not authorized").build();
        }
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Managers> findAll() {
        return super.findAll();
    }

    @GET
    @Path("username/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Managers> findByUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Managers.findByManUsername").setParameter("manUsername", username);
        return query.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Managers> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
