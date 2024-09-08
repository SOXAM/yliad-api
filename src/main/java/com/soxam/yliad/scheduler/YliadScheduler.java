package com.soxam.yliad.scheduler;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class YliadScheduler {
    private ThreadPoolTaskScheduler scheduler;
    private Map<String, ScheduledFuture<?>> map;
    
    public YliadScheduler() {
        log.info("Construct!!");
        scheduler = new ThreadPoolTaskScheduler();
        scheduler.initialize();
        map = new ConcurrentHashMap<>();
    }

    public void schedule(String name, long sec, Runnable runnable) {
        log.info("schedule: {}, {}", name, sec);
        ScheduledFuture<?> handle = scheduler.schedule(runnable, new PeriodicTrigger(Duration.ofSeconds(sec)));
        map.put(name, handle);
    }

    public void cancel(String name) {
        log.info("cancel {} task..", name);
        map.get(name).cancel(false);
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
