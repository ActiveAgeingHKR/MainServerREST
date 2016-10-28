/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Employees;
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

/**
 *
 * @author Chris
 */
@Stateless
@Path("employees")
public class EmployeesFacadeREST extends AbstractFacade<Employees> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    public EmployeesFacadeREST() {
        super(Employees.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Employees entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Employees entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Employees find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employees> findAll() {
        return super.findAll();
    }

    
    @GET
    @Path("/firstname/{firstname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Employees> findByEmpFtname(@PathParam("firstname") String firstname) {
        Query query = em.createNamedQuery("Employees.findByEmpFirstname").setParameter("empFirstname", firstname);
        return query.getResultList();
    }
    
    @GET
    @Path("/lastname/{lastname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Employees> findByEmpLastname(@PathParam("lastname") String lastname) {
        Query query = em.createNamedQuery("Employees.findByEmpLastname").setParameter("empLastname", lastname);
        return query.getResultList();
    }
    
    @GET
    @Path("/username/{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Employees> findByEmpUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Employees.findByEmpUsername").setParameter("empUsername", username);
        return query.getResultList();
    }
    @GET
    @Path("/password/{password}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Employees> findByEmpPassword(@PathParam("password") String password) {
        Query query = em.createNamedQuery("Employees.findByEmpPassword").setParameter("empPassword", password);
        return query.getResultList();
    }
    
        @GET
    @Path("/email/{email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Employees> findByEmpEmail(@PathParam("email") String email) {
        Query query = em.createNamedQuery("Employees.findByEmpEmail").setParameter("empEmail", email);
        return query.getResultList();
    }
    
    @GET
    @Path("/phone/{phone}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Employees> findByEmpPhone(@PathParam("phone") String phone) {
        Query query = em.createNamedQuery("Employees.findByEmpPhone").setParameter("empPhone", phone);
        return query.getResultList();
    }
    @GET
    @Path("/registered/{registered}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Employees> findByEmpRegistered(@PathParam("registered") boolean registered) {
        Query query = em.createNamedQuery("findByEmpRegistered.findByEmpPassword").setParameter("empRegistered", registered);
        return query.getResultList();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employees> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
