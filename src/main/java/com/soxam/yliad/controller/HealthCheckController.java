package com.soxam.yliad.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soxam.yliad.dto.HealthCheckDTO;

@RestController
public class HealthCheckController {

	@GetMapping("/health_check")
	public HealthCheckDTO healthCheck() {
		return HealthCheckDTO.builder().date(LocalDateTime.now()).message("I am alive!!").build();
	}

}
