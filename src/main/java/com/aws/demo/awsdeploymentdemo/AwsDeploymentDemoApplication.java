package com.aws.demo.awsdeploymentdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AwsDeploymentDemoApplication {

    @GetMapping
    public String welcome() {
        return "Hello, this is demo for AWS deployment";
    }

    @GetMapping("/who")
    public String welcome2() {
        return "I'm ubuntu from AWS EC2.";
    }

    public static void main(String[] args) {
        SpringApplication.run(AwsDeploymentDemoApplication.class, args);
    }

}
