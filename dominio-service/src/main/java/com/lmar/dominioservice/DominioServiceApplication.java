package com.lmar.dominioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DominioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominioServiceApplication.class, args);
	}

}
