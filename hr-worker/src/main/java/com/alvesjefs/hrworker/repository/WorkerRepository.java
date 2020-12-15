package com.alvesjefs.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.hrworker.domain.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}