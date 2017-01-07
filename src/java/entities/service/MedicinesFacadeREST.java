/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.CustomersTakesMedicines;
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

/**
 *
 * @author Chris
 */
@Stateless
@Path("medicines")
public class MedicinesFacadeREST extends AbstractFacade<Medicines> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    public MedicinesFacadeREST() {
        super(Medicines.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Medicines entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Medicines entity) {
        super.edit(entity);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Medicines entity) {
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
    public Medicines find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Medicines> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Medicines> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("/medname/{medname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Medicines> findMedName(@PathParam("medname") String medname) {
        Query query = em.createNamedQuery("Medicines.findByMedName").setParameter("medName", medname);
        return query.getResultList();
    }
    
    @GET
    @Path("/volume/{volume}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Medicines> findVolume(@PathParam("volume") int volume) {
        Query query = em.createNamedQuery("Medicines.findByVolume").setParameter("volume", volume);
        return query.getResultList();
    }
    
    @GET
    @Path("/medunit/{medunit}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Medicines> findMeasurementUnit(@PathParam("medunit") int medunit) {
        Query query = em.createNamedQuery("Medicines.findByMedMeasurementUnit").setParameter("medMeasurementUnit", medunit);
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
