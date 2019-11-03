package net.harishgowda.springboot.SpringBootSwagger.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.harishgowda.springboot.SpringBootSwagger.resources.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    Map<String, Employee> employees = new HashMap<>();


    @GetMapping("/{id}")
    @ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Employee getEmployee(@ApiParam(value="Employee id",required = true)  @PathVariable String id) {

        return employees.get(id);
    }

    @GetMapping("/")
    @ApiOperation(value="Find all employees",notes="Get list of all employees",response=List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<Employee> getAllEmployee() {
        return new ArrayList<Employee>(employees.values());
    }

    @PostMapping("/")
    @ApiOperation(value="Create a new employee",notes="Create a new employee",response=List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Employee createEmployee(@ApiParam(value="Send employee object to be created",required = true) @RequestBody Employee employee) {

        employees.put(employee.getEmpid(), employee);
        return employee;
    }

    @PutMapping("/")
    @ApiOperation(value="Update a employee",notes="Update a employee",response=Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Employee updateEmployee(@ApiParam(value="Send employee object to be updated",required = true)@RequestBody Employee employee) {

        employees.put(employee.getEmpid(), employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete a employee based on employee id",notes="Delete a employee for a given id",response=Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Employee deleteEmployee(@PathVariable String id) {
        return employees.remove(id);

    }

    @DeleteMapping("/")
    @ApiOperation(value="Delete all employees",notes="Delete all employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted all employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public void deleteAllEmployee() {
        employees.clear();

    }


}
