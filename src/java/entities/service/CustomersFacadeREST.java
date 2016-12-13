/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Customers;
import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Chris
 */
@Stateless
@Path("customers")
public class CustomersFacadeREST extends AbstractFacade<Customers> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    public CustomersFacadeREST() {
        super(Customers.class);
    }
    
    

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Customers entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Customers entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Customers find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("/firstname/{firstname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> findCusFirstName(@PathParam("firstname") String firstname) {
        Query query = em.createNamedQuery("Customers.findByCuFirstname").setParameter("cuFirstname", firstname);
        return query.getResultList();
    }
    
    @GET
    @Path("/lastname/{lastname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> findCusLastName(@PathParam("lastname") String lastname) {
        Query query = em.createNamedQuery("Customers.findByCuLastname").setParameter("cuLastname", lastname);
        return query.getResultList();
    }
    
    @GET
    @Path("/birthdate/{birthdate}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> findCusBirthdate(@PathParam("birthdate") String birthdate) {
        Query query = em.createNamedQuery("Customers.findByCuBirthdate").setParameter("cuBirthdate", birthdate);
        return query.getResultList();
    }
    @GET
    @Path("/address/{address}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> findCusAddress(@PathParam("address") String address) {
        Query query = em.createNamedQuery("Customers.findByCuAddress").setParameter("cuAddress", address);
        return query.getResultList();
    }
    @GET
    @Path("/personnummer/{personnummer}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> findCusPersonNummer(@PathParam("personnummer") String personnummer) {
        Query query = em.createNamedQuery("Customers.findByCuPersonnummer").setParameter("cuPersonnummer", personnummer);
        return query.getResultList();
    }
    
    @GET
    @Path("/searchfname/{fname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> searchForFirstName(@PathParam("fname") String fname) {
        Query query = em.createNamedQuery("Customers.searchForFirstName").setParameter("cuFirstname", "%"+fname+"%");
        return query.getResultList();
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
