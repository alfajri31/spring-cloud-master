package br.com.example.controller;

import br.com.example.broker.producer.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final TopicProducer topicProducer;
    @GetMapping(value = "/send")
    public void send(){
        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader("website", "baeldung.com".getBytes()));
        ProducerRecord<String, String> record = new ProducerRecord<>("topico.teste", null, System.currentTimeMillis(), "message", "Hello World", headers);
//        topicProducer.send("Mensagem de teste enviada ao tópico");
        topicProducer.send(record);
    }
}
