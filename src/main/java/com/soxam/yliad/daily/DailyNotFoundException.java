package com.soxam.yliad.daily;

public class DailyNotFoundException extends RuntimeException {
    
    DailyNotFoundException(Long id) {
        super("Could not find daily " + id);
    }
}
