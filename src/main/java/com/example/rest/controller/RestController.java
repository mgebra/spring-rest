package com.example.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @GetMapping("echo")
    public ResponseEntity<String> echo(String data) {
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("sleep")
    public ResponseEntity<Integer> sleep(Integer seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);

        return new ResponseEntity<>(seconds, HttpStatus.OK);
    }

    @GetMapping("error")
    public ResponseEntity<Boolean> error(boolean throwException) throws InterruptedException {
        if (throwException) {
            throw new RuntimeException();
        }

        return new ResponseEntity<>(throwException, HttpStatus.OK);
    }
}
