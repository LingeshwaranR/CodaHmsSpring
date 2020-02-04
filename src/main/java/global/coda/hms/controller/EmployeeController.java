package global.coda.hms.controller;

import global.coda.hms.model.CustomResponse;
import global.coda.hms.model.Employee;
import global.coda.hms.service.EmployeeService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
@RequestMapping("/api/employee")
public class
EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/add")
    public CustomResponse<Employee> createEmployee(@RequestBody Employee employee, HttpServletRequest httpServletRequest){
        CustomResponse<Employee> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setRequestId((Integer) httpServletRequest.getAttribute("requestId"));
        customResponse.setObject(employeeService.createEmployee(employee));
        return customResponse;
    }
    @PostMapping("/read/{id}")
    public CustomResponse<Collection<Employee>> createEmployee(@PathVariable int id , HttpServletRequest httpServletRequest){
        CustomResponse<Collection<Employee>> customResponse = new CustomResponse<>();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.SC_OK);
        customResponse.setRequestId((Integer) httpServletRequest.getAttribute("requestId"));
        customResponse.setObject(employeeService.readEmployee(id));
        return customResponse;
    }
}
