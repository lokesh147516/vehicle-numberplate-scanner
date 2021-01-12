package com.violation.mail.mailingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.violation.mail.mailingservice")
@EnableDiscoveryClient
public class MailingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailingServiceApplication.class, args);
	}
}
