package com.soxam.yliad.daily;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DailyService {

	private final DailyRepository dailyRepository;

	DailyService(DailyRepository repository) {
		this.dailyRepository = repository;
	}

	List<Daily> allDaily() {
		return dailyRepository.findAll();
	}

	Daily newDaily(Daily newDaily) {
		newDaily.setCreateTime(LocalDateTime.now());
		newDaily.setModifiedTime(LocalDateTime.now());
		return dailyRepository.save(newDaily);
	}

	Daily oneDaily(Long id) {
		return dailyRepository.findById(id).orElseThrow(() -> new DailyNotFoundException(id));
	}

	Daily replaceDaily(Daily newDaily, Long id) {
		return dailyRepository.findById(id).map(daily -> {
			daily.setTitle(newDaily.getTitle());
			daily.setUrl(newDaily.getUrl());
			daily.setContent(newDaily.getContent());
			daily.setModifiedTime(LocalDateTime.now());
			return dailyRepository.save(daily);
		}).orElseGet(() -> {
			return newDaily(newDaily);
		});
	}

	void deleteDaily(Long id) {
		dailyRepository.deleteById(id);
	}

}
