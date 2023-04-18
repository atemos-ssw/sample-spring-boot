package com.atemos.energy.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Data
public class SensorResponse {

	String result;
	String message; 
	ACSensor _data_;
}

