package com.soxam.yliad.daily;

import org.springframework.data.jpa.repository.JpaRepository;

interface DailyRepository extends JpaRepository<Daily, Long> {
    
}
