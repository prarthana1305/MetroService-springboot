package com.example.MetroService.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "metro.exchange";
    public static final String CHECKOUT_ROUTING_KEY = "metro.checkout";
    public static final String SOS_ROUTING_KEY = "metro.sos";

    @Bean
    public TopicExchange metroExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue checkoutQueue() {
        return new Queue("checkout.queue");
    }

    @Bean
    public Queue sosQueue() {
        return new Queue("sos.queue");
    }

    @Bean
    public Binding bindingCheckout(Queue checkoutQueue, TopicExchange metroExchange) {
        return BindingBuilder.bind(checkoutQueue).to(metroExchange).with(CHECKOUT_ROUTING_KEY);
    }

    @Bean
    public Binding bindingSOS(Queue sosQueue, TopicExchange metroExchange) {
        return BindingBuilder.bind(sosQueue).to(metroExchange).with(SOS_ROUTING_KEY);
    }
}
