package com.xyzcompany.employeeservice.employee_api.listener;

import com.xyzcompany.employeeservice.employee_api.config.RabbitMQConfig;
import com.xyzcompany.employeeservice.employee_api.event.EmployeeCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventListener {

    private final RabbitTemplate rabbitTemplate;

    public EmployeeEventListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @EventListener
    public void onEmployeeCreated(EmployeeCreatedEvent event) {
        // Send the employee data to the RabbitMQ queue
        rabbitTemplate.convertAndSend(RabbitMQConfig.EMPLOYEE_QUEUE, event.getEmployee());
    }
}
