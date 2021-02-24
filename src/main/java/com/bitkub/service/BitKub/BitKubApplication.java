package com.bitkub.service.BitKub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication
@EnableDiscoveryClient

public class BitKubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitKubApplication.class, args);
	}


	//@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){

		return  new RestTemplate();
	}





}
