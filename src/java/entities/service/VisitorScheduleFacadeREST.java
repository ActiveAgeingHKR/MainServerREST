/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.VisitorSchedule;
import entities.VisitorSchedulePK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("entities.visitorschedule")
public class VisitorScheduleFacadeREST extends AbstractFacade<VisitorSchedule> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    private VisitorSchedulePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;visSchId=visSchIdValue;visitorsVisId=visitorsVisIdValue;customersCuId=customersCuIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.VisitorSchedulePK key = new entities.VisitorSchedulePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> visSchId = map.get("visSchId");
        if (visSchId != null && !visSchId.isEmpty()) {
            key.setVisSchId(new java.lang.Integer(visSchId.get(0)));
        }
        java.util.List<String> visitorsVisId = map.get("visitorsVisId");
        if (visitorsVisId != null && !visitorsVisId.isEmpty()) {
            key.setVisitorsVisId(new java.lang.Integer(visitorsVisId.get(0)));
        }
        java.util.List<String> customersCuId = map.get("customersCuId");
        if (customersCuId != null && !customersCuId.isEmpty()) {
            key.setCustomersCuId(new java.lang.Integer(customersCuId.get(0)));
        }
        return key;
    }

    public VisitorScheduleFacadeREST() {
        super(VisitorSchedule.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(VisitorSchedule entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, VisitorSchedule entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.VisitorSchedulePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public VisitorSchedule find(@PathParam("id") PathSegment id) {
        entities.VisitorSchedulePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VisitorSchedule> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VisitorSchedule> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
