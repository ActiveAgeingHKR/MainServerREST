/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Customers;
import entities.CustomersTakesMedicines;
import entities.CustomersTakesMedicinesPK;
import java.util.Date;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Chris
 */
@Stateless
@Path("customersmedicines")
public class CustomersTakesMedicinesFacadeREST extends AbstractFacade<CustomersTakesMedicines> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    private CustomersTakesMedicinesPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;customersId=customersIdValue;medicinsId=medicinsIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.CustomersTakesMedicinesPK key = new entities.CustomersTakesMedicinesPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> customersId = map.get("customersId");
        if (customersId != null && !customersId.isEmpty()) {
            key.setCustomersId(new java.lang.Integer(customersId.get(0)));
        }
        java.util.List<String> medicinsId = map.get("medicinsId");
        if (medicinsId != null && !medicinsId.isEmpty()) {
            key.setMedicinsId(new java.lang.Integer(medicinsId.get(0)));
        }
        return key;
    }

    public CustomersTakesMedicinesFacadeREST() {
        super(CustomersTakesMedicines.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(CustomersTakesMedicines entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, CustomersTakesMedicines entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.CustomersTakesMedicinesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public CustomersTakesMedicines find(@PathParam("id") PathSegment id) {
        entities.CustomersTakesMedicinesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<CustomersTakesMedicines> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CustomersTakesMedicines> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("/meddosage/{meddosage}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CustomersTakesMedicines> findMedDosage(@PathParam("meddosage") String meddosage) {
        Query query = em.createNamedQuery("CustomersTakesMedicines.findByMedDosage").setParameter("medDosage", meddosage);
        return query.getResultList();
    }
    
    @GET
    @Path("/medstartdate/{medstartdate}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CustomersTakesMedicines> findMedStartDate(@PathParam("medstartdate") Date medstartdate) {
        Query query = em.createNamedQuery("CustomersTakesMedicines.findByMedStartDate").setParameter("medStartDate", medstartdate);
        return query.getResultList();
    }
    
    @GET
    @Path("/medintakesched/{medintakesched}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CustomersTakesMedicines> findMedIntakeSched(@PathParam("medintakesched") double medintakesched) {
        Query query = em.createNamedQuery("CustomersTakesMedicines.findByMedIntakeSched").setParameter("medInterval", medintakesched);
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
