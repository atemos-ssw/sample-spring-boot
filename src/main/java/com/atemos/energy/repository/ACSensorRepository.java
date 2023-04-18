package com.atemos.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atemos.energy.dao.ACSensor;
import com.atemos.energy.dao.SensorResponse; 

public interface ACSensorRepository extends JpaRepository<ACSensor, Integer>{

}
