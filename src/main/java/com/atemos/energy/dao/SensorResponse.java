package com.atemos.energy.dao;
 
import lombok.AllArgsConstructor;
import lombok.Data; 
 

@Data
@AllArgsConstructor
public class SensorResponse {

	String result;
	String message; 
	ACSensor _data_;
}

