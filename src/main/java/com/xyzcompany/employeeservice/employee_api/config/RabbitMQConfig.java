package com.xyzcompany.employeeservice.employee_api.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    public static final String EMPLOYEE_QUEUE = "MyEmployeeQueue";

    @Bean
    public Queue employeeQueue() {
        return new Queue(EMPLOYEE_QUEUE, false);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    public void initializeQueues(RabbitAdmin rabbitAdmin, Queue employeeQueue) {
        rabbitAdmin.declareQueue(employeeQueue);
    }
}
