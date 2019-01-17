package org.accolite.java.EmployeeManagement.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.accolite.java.EmployeeManagement.dto.EmployeeDTO;
import org.accolite.java.EmployeeManagement.service.EmployeeService;

@Path("myemployee")
public class EmployeeController {
	EmployeeService empService = new EmployeeService();
	
	@GET
	@Path("getallemployee")
    @Produces("application/json")
    public List<EmployeeDTO> getAllEmployees() {
        return empService.getAllEmployee();
    }
	
	@GET
	@Path("getemployee/{id}")
	@Produces("application/json")
	public EmployeeDTO getEmployeeID(@PathParam("id") String id) {
		System.out.println("GetEmp*******"+id+"********");
		return empService.getEmployee(id);
	}
	
	@GET
	@Path("deleteemployee/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployeeID(@PathParam("id") String id) {
		System.out.println("Delete*******"+id+"********");
		return empService.deleteEmployee(id);
	}
	
	
	@POST
	@Path("addemployee")
	@Consumes("application/json")
	@Produces(MediaType.TEXT_PLAIN)
	public String addEmployee(EmployeeDTO emp) {
		System.out.println("AddEmp*******"+emp+"********");
		return empService.addEmployee(emp);
	}
	
	@POST
	@Path("updateemployee")
	@Consumes("application/json")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateemployee(EmployeeDTO emp) {
		System.out.println("UpdateEmp*******"+emp+"********");
		return empService.updateEmployee(emp);
	}
	
	

	
}
