package com.darrylion.healthinsurancerestapi.repository;

import com.darrylion.healthinsurancerestapi.entity.PatientPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientPolicyRepository extends JpaRepository<PatientPolicy, Long> {
}
