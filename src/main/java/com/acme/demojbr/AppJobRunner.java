package com.acme.demojbr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppJobRunner {

    public static final String ROOT_PATH = "/job-runner/";

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", ROOT_PATH);
        SpringApplication.run(AppJobRunner.class, args);
    }

}

