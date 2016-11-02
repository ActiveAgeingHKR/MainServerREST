/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Chris
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entities.service.CompanyFacadeREST.class);
        resources.add(entities.service.CustomersFacadeREST.class);
        resources.add(entities.service.CustomersTakesMedicinesFacadeREST.class);
        resources.add(entities.service.DevicesCustomersFacadeREST.class);
        resources.add(entities.service.EmployeeScheduleFacadeREST.class);
        resources.add(entities.service.EmployeesFacadeREST.class);
        resources.add(entities.service.IncidentsFacadeREST.class);
        resources.add(entities.service.ManagersFacadeREST.class);
        resources.add(entities.service.MedicinesFacadeREST.class);
        resources.add(entities.service.NotesFacadeREST.class);
        resources.add(entities.service.PersonsFacadeREST.class);
        resources.add(entities.service.RemindersFacadeREST.class);
        resources.add(entities.service.TasksFacadeREST.class);
        resources.add(entities.service.VisitorScheduleFacadeREST.class);
        resources.add(entities.service.VisitorsFacadeREST.class);
    }
    
}
