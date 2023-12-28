package com.employee.employeemanager.service;

import com.employee.employeemanager.Repo.EmployeeRepo;
import com.employee.employeemanager.exception.UserNotFoundException;
import com.employee.employeemanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

     public Employee addEmployee(Employee employee){
         employee.setEmployeeCode(UUID.randomUUID().toString());
         return employeeRepo.save(employee);
     }

     public List<Employee> findAllEmployee(){
         return employeeRepo.findAll();
     }

     public Employee updateEmployee(Employee employee){
         return employeeRepo.save(employee);

     }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);

    }

    public Employee findById(Long id){
         return employeeRepo.findEmploeeById(id)
                 .orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
    }
}
