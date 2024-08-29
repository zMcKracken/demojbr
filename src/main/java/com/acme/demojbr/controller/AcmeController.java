package com.acme.demojbr.controller;

import org.jobrunr.scheduling.JobBuilder;
import org.jobrunr.scheduling.JobScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/test")
public class AcmeController {

    @Autowired
    public JobScheduler jobScheduler;

    private static final Logger logger = LoggerFactory.getLogger(AcmeController.class);

    @GetMapping(value = "/job")
    public ResponseEntity<Object> test() {

        jobScheduler.create(JobBuilder.aJob()
                .withName("A job requested for pippo")
                .withLabels(UUID.randomUUID().toString(), LocalDateTime.now().toString(), "test")
                .withDetails(() -> System.out.println("job done")));

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
