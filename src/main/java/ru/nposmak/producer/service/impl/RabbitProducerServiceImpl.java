package ru.nposmak.producer.service.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.nposmak.producer.dto.DataDto;
import ru.nposmak.producer.service.RabbitProducerService;

@Slf4j
@Data
@Service
public class RabbitProducerServiceImpl implements RabbitProducerService {

    @Value("${rabbit.exchange}")
    private String exchangeName;
    @Value("${rabbit.routing}")
    private String routingKey;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(DataDto dto) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, dto);
        log.info("Отправка данных в очередь");
    }
}
