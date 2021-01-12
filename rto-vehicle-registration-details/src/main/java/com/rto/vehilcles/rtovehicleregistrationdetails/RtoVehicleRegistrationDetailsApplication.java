package com.rto.vehilcles.rtovehicleregistrationdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RtoVehicleRegistrationDetailsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RtoVehicleRegistrationDetailsApplication.class, args);
		
		
		
	}

}
