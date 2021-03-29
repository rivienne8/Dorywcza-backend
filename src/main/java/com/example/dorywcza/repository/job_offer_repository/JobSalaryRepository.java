package com.example.dorywcza.repository.job_offer_repository;

import com.example.dorywcza.model.offer.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSalaryRepository extends JpaRepository <Salary, Long> {
}
