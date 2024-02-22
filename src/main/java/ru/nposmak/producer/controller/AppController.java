package ru.nposmak.producer.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nposmak.producer.dto.DataDto;
import ru.nposmak.producer.service.RabbitProducerService;

@Slf4j
@Data
@RestController
public class AppController {

    private final RabbitProducerService rabbitProducerService;
    record ResponseDto(String message){}

    @PostMapping("/api/send")
    public ResponseDto sendMessageToRabbit(@RequestBody DataDto dataDto){
        rabbitProducerService.sendMessage(dataDto);
        return new ResponseDto("Данные получены");
    }
}
