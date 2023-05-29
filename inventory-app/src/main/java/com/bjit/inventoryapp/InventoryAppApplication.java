package com.bjit.inventoryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InventoryAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryAppApplication.class, args);
	}

}
