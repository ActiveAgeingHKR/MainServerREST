/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.EmployeeSchedule;
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

/**
 *
 * @author Chris
 */
@Stateless
@Path("employeeschedule")
public class EmployeeScheduleFacadeREST extends AbstractFacade<EmployeeSchedule> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    public EmployeeScheduleFacadeREST() {
        super(EmployeeSchedule.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(EmployeeSchedule entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, EmployeeSchedule entity) {
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
    public EmployeeSchedule find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("date/{date}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeSchedule> findByDate(@PathParam("date") String date) {
        Query query = em.createNamedQuery("EmployeeSchedule.findBySchDate").setParameter("schDate", date);
        return query.getResultList();
    }
    
    @GET
    @Path("customerID/{cuId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeSchedule> findByCustomerID(@PathParam("cuId") Integer cuId) {
        Query query = em.createNamedQuery("EmployeeSchedule.findByCustomerId").setParameter("cuId", cuId);
        return query.getResultList();
    }
    
    @GET
    @Path("employeeID/{empId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeSchedule> findByEmployeeID(@PathParam("empId") Integer empId) {
        Query query = em.createNamedQuery("EmployeeSchedule.findByEmployeeId").setParameter("empId", empId);
        return query.getResultList();
    }
    
    @GET
    @Path("getempschedulebyempId/{empId}")
    @Produces({MediaType.TEXT_PLAIN})
    public String findByEmployeeIDString(@PathParam("empId") Integer empId) {
        Query query = em.createNamedQuery("EmployeeSchedule.findByEmployeeIdFalse").setParameter("empId", empId);
        List<String> schedule = new ArrayList<>();
        List<EmployeeSchedule> list = query.getResultList();
        for(int i=0; i<list.size(); i++){
            schedule.add(list.get(i).getCustomersCuId().getCuId()+";"+list.get(i).getCustomersCuId().getCuLastname()+";"
                    +list.get(i).getCustomersCuId().getCuFirstname()+";"+list.get(i).getCustomersCuId().getCuAddress()+";"
                    +list.get(i).getSchDate()+
                    ";"+list.get(i).getSchFromTime()+";"+list.get(i).getSchUntilTime()+";"+
                    list.get(i).getEmplVisitedCust());
        }
        return schedule.toString();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeSchedule> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeSchedule> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("/findschafterdate/{date}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeSchedule> findSchAfterDate(@PathParam("schDate") String schDate) {
        Query query = em.createNamedQuery("EmployeeSchedule.findSchAfterDate").setParameter("schDate", schDate);  
        List<EmployeeSchedule> schedule = query.getResultList();
        return schedule;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
