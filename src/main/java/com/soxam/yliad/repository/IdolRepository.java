package com.soxam.yliad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soxam.yliad.entity.IdolEntity;

@Repository
public interface IdolRepository extends JpaRepository<IdolEntity, Long> {

}
