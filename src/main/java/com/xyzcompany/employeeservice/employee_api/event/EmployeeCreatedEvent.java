package com.xyzcompany.employeeservice.employee_api.event;

import com.xyzcompany.employeeservice.employee_api.model.Employee;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EmployeeCreatedEvent extends ApplicationEvent {

    private final Employee employee;

    public EmployeeCreatedEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

}
