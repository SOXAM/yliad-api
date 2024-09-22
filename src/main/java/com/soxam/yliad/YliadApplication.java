package com.soxam.yliad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.soxam.yliad.image.storage.StorageProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class YliadApplication {

	public static void main(String[] args) {
		SpringApplication.run(YliadApplication.class, args);
	}

}
