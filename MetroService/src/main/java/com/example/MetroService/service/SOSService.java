package com.example.MetroService.service;


import com.example.MetroService.model.SOSAlert;
import com.example.MetroService.repository.SOSAlertRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service

public class SOSService {
    private static final Logger log = LoggerFactory.getLogger(SOSService.class);
    //
    private final RabbitTemplate rabbitTemplate;
    private final SOSAlertRepository sosAlertRepository;

    public SOSService(RabbitTemplate rabbitTemplate, SOSAlertRepository sosAlertRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.sosAlertRepository = sosAlertRepository;
    }

    public void processSOS(SOSAlert alert) {
        sosAlertRepository.save(alert);
        log.info("SOS alert saved to the database: {}", alert);


        rabbitTemplate.convertAndSend("metro.exchange", "metro.sos", alert);
        log.info("SOS alert published to RabbitMQ on exchange 'metro.exchange' with routing key 'metro.sos': {}", alert);
    }
}
