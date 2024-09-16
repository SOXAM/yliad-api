package com.soxam.yliad.daily;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyController {

	private final DailyService dailyService;

	DailyController(DailyService service) {
		this.dailyService = service;
	}

	@GetMapping("/daily")
	List<Daily> allDaily() {
		return dailyService.allDaily();
	}

	@PostMapping("/daily")
	Daily newDaily(@RequestBody Daily newDaily) {
		return dailyService.newDaily(newDaily);
	}

	@GetMapping("/daily/{id}")
	Daily oneDaily(@PathVariable Long id) {
		return dailyService.oneDaily(id);
	}

	@PutMapping("/daily/{id}")
	Daily replaceDaily(@RequestBody Daily newDaily, @PathVariable Long id) {
		return dailyService.replaceDaily(newDaily, id);
	}

	@DeleteMapping("/daily/{id}")
	void deleteDaily(@PathVariable Long id) {
		dailyService.deleteDaily(id);
	}

}
