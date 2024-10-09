package com.xyzcompany.employeeservice.employee_api.service;

import com.xyzcompany.employeeservice.employee_api.event.EmployeeCreatedEvent;
import com.xyzcompany.employeeservice.employee_api.model.Employee;
import com.xyzcompany.employeeservice.employee_api.repository.EmployeeRepo;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ApplicationEventPublisher eventPublisher;

    public EmployeeService(EmployeeRepo employeeRepo, ApplicationEventPublisher eventPublisher) {
        this.employeeRepo = employeeRepo;
        this.eventPublisher = eventPublisher;
    }

    public Employee createEmployee(Employee employee){
        Employee savedEmployee = employeeRepo.save(employee);
        eventPublisher.publishEvent(new EmployeeCreatedEvent(this, savedEmployee));
        return savedEmployee;
    }

    public Optional<Employee> findEmployeeByID(Long id){
        return employeeRepo.findById(id);
    }

    public Optional<Employee> getEmployeeByEmailID(String email){
        return employeeRepo.findByEmail(email);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
}
