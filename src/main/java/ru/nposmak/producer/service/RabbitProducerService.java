package ru.nposmak.producer.service;

import ru.nposmak.producer.dto.DataDto;

import java.util.List;

public interface RabbitProducerService {
    void sendMessage(DataDto dtos);

}
