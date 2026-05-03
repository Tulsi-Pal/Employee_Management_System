package net.tulsi.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.tulsi.ems_backend.dto.EmployeeDto;
import net.tulsi.ems_backend.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    //build add employee Rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
   return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    //Build get all employees rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
         List<EmployeeDto>employees=employeeService.getAllEmployees();
         return ResponseEntity.ok(employees);

    }
    //build update employee rest api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
     EmployeeDto employeeDto=   employeeService.updateEmployee(employeeId,updatedEmployee);
     return ResponseEntity.ok(employeeDto);
    }
    //build delete employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
