/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.DevicesCustomers;
import entities.Medicines;
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
@Path("devicescustomers")
public class DevicesCustomersFacadeREST extends AbstractFacade<DevicesCustomers> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    public DevicesCustomersFacadeREST() {
        super(DevicesCustomers.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(DevicesCustomers entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, DevicesCustomers entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public DevicesCustomers find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Path("/id/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String getCuIdFromDevId(@PathParam("id") String id) {
        //return just the customer ID related to this device ID
        DevicesCustomers devCust = super.find(id);
        int cuId = devCust.getCustomersCuId().getCuId();
        return String.valueOf(cuId);
        
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<DevicesCustomers> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<DevicesCustomers> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("/devname/{devname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Medicines> findDevName(@PathParam("devname") String devname) {
        Query query = em.createNamedQuery("DevicesCustomers.findByDevName").setParameter("devName", devname);
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
