package com.soxam.yliad.daily;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LoadTestDaily {
    @Bean
    CommandLineRunner initDatabase(DailyService dailyService) {
        return args -> {
            log.info("Preloading " +
                dailyService.newDaily(Daily.builder().title("ISA").content("I love isa...").build()));
            log.info("Preloading " +
                dailyService.newDaily(Daily.builder().title("ISA2").content("I love isa...").build()));
            log.info("Preloading " +
                dailyService.newDaily(Daily.builder().title("ISA3").content("I love isa...").build()));
            log.info("Preloading " +
                dailyService.newDaily(Daily.builder().title("ISA4").content("I love isa...").build()));
            log.info("Preloading " +
                dailyService.newDaily(Daily.builder().title("ISA5").content("I love isa...").build()));
        };
    }
}
