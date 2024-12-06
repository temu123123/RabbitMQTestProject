package com.temu.rabbitmq.controller;

import com.temu.rabbitmq.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MessageSender messageSender;

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody String text){
        if(text.isBlank()){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        messageSender.send(text);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

}
