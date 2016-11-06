/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Tasks;
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

/**
 *
 * @author Chris
 */
@Stateless
@Path("entities.tasks")
public class TasksFacadeREST extends AbstractFacade<Tasks> {

    @PersistenceContext(unitName = "MainServerRESTPU")
    private EntityManager em;

    public TasksFacadeREST() {
        super(Tasks.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Tasks entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Tasks entity) {
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
    public Tasks find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tasks> findAll() {
        return super.findAll();
    }
//findByTaskTitle findByTaskContent findByTaskdueDate findByTaskCompl
     @GET
    @Path("/title/{title}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Tasks> findByTaskTitle(@PathParam("title") String title) {
        Query query = em.createNamedQuery("Tasks.findByTaskTitle").setParameter("taskTitle", title);
        return query.getResultList();
    }
       @GET
    @Path("/conten/{conten}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Tasks> findByTaskContent(@PathParam("conten") String conten) {
        Query query = em.createNamedQuery("Tasks.findByTaskContent").setParameter("taskContent", conten);
        return query.getResultList();
    }
         @GET
    @Path("/dueDate/{dueDate}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Tasks> findByTaskdueDate(@PathParam("dueDate") Date dueDate) {
        Query query = em.createNamedQuery("Tasks.findByTaskdueDate").setParameter("taskdueDate", dueDate);
        return query.getResultList();
    }
    @GET
    @Path("/compl/{compl}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Tasks> findByTaskCompl(@PathParam("compl") boolean compl) {
        Query query = em.createNamedQuery("Tasks.findByTaskCompl").setParameter("taskCompl", compl);
        return query.getResultList();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tasks> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

