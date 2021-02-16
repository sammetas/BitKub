package com.bitkub.service.BitKub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication

public class BitKubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitKubApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){

		return  new RestTemplate();
	}





}
