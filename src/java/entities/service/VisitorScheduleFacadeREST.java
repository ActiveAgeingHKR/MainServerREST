/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.VisitorSchedule;
import entities.VisitorSchedulePK;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Chris
 */
@Stateless
@Path("visitorschedule")
public class VisitorScheduleFacadeREST extends AbstractFacade<VisitorSchedule> {
    
    /** The path to the folder where we want to store the uploaded files */
    private static final String UPLOAD_FOLDER = "C:\\Users\\Chris\\Documents\\NetBeansProjects\\MainServerREST\\src\\java\\resources\\";

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
    
    @POST
    @Path("upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response upload(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
        
        // check if all form parameters are provided
        if (uploadedInputStream == null || fileDetail == null){
            return Response.status(400).entity("Invalid form data").build();
        }
        
        // create our destination folder, if it not exists
	try {
            createFolderIfNotExists(UPLOAD_FOLDER);
	} catch (SecurityException se) {
            return Response.status(500)
            	.entity("Can not create destination folder on server")
            	.build();
	}
        
        String uploadedFileLocation = UPLOAD_FOLDER + fileDetail.getFileName();
	try {
            saveToFile(uploadedInputStream, uploadedFileLocation);
	} catch (IOException e) {
            return Response.status(500).entity("Can not save file "+e).build();
	}
	return Response.status(200)
	.entity("File saved to " + uploadedFileLocation).build();
        
        
			
        
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
    @Path("visit/{hash}")
    @Produces({MediaType.TEXT_HTML})
    public String getVisitorCard(@PathParam("hash") String hash) throws IOException {
        VisitorSchedule vs = null;
        String htmlString = "";
        Query query = em.createNamedQuery("VisitorSchedule.findByVisitHash").setParameter("visitHash", hash);
        if(query.getResultList() != null) {
            vs = (VisitorSchedule)query.getResultList().get(0);
        //if a visitor schedule with this hashcode exists, use the fields to replace the defaults in html template
        File htmlTemplateFile = new File("resources/visitortemplate.html");
        htmlString = FileUtils.readFileToString(htmlTemplateFile);
        htmlString = htmlString.replace("$Firstname", vs.getVisitors().getVisFirstname());
        htmlString = htmlString.replace("$Lirstname", vs.getVisitors().getVisLastname());
        htmlString = htmlString.replace("$Company", vs.getVisitors().getCompanyCompId().getCompName());
        htmlString = htmlString.replace("$From", vs.getVisitStartTime().toString());
        htmlString = htmlString.replace("$Until", vs.getVisitEndTime().toString());
        File newHtmlFile = new File("path/new.html");
        FileUtils.writeStringToFile(newHtmlFile, htmlString);
        }
        return htmlString;
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
    
    /**
	 * Utility method to save InputStream data to target location/file
	 * 
	 * @param inStream
	 *            - InputStream to be saved
	 * @param target
	 *            - full path to destination file
	 */
	private void saveToFile(InputStream inStream, String target)
			throws IOException {
            
                OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];
		out = new FileOutputStream(new File(target));
		while ((read = inStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
            
		
	}
    
    /**
	 * Creates a folder to desired location if it not already exists
	 * 
	 * @param dirName
	 *            - full path to the folder
	 * @throws SecurityException
	 *             - in case you don't have permission to create the folder
	 */
    private void createFolderIfNotExists(String dirName)
			throws SecurityException {
		File theDir = new File(dirName);
		if (!theDir.exists()) {
			theDir.mkdir();
		}
    }
    
}
