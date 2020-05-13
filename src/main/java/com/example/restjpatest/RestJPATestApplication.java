package com.example.restjpatest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestJPATestApplication {

  private static final Logger log = LoggerFactory.getLogger(RestJPATestApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(RestJPATestApplication.class, args);
  }

}