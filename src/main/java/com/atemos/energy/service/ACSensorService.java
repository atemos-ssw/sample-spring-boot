package com.atemos.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atemos.energy.dao.ACSensor;
import com.atemos.energy.dao.SensorResponse;
import com.atemos.energy.repository.ACSensorRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ACSensorService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ACSensorRepository acSensorRepository;
	

	public ACSensor add(ACSensor acsensor) {
		acSensorRepository.save(acsensor);
		acSensorRepository.flush();
		return acsensor;
		
	}
	
}
