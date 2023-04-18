package com.atemos.energy.scheduler;


import java.net.URI;
 

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.atemos.energy.dao.SensorResponse;
import com.atemos.energy.service.ACSensorService;

public class MeteringJob  extends QuartzJobBean {
	private static final Logger log = LoggerFactory.getLogger(MeteringJob.class);

	@Autowired
	private Environment env;
	  
	@Autowired
	   RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	ACSensorService acSensorService;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//		log.info("10초마다 Job 실행");
		RestTemplate restTemplate = restTemplateBuilder.build();
		URI uri = UriComponentsBuilder.fromUriString(env.getProperty("metering.url")).encode().build().toUri();
//		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
//		log.info(response.getStatusCode().toString());
//		log.info(response.getBody());
		ResponseEntity<SensorResponse> response = restTemplate.getForEntity(uri, SensorResponse.class); 
		log.info(response.toString());
//		final String uri = "https://alexwohlbruck.github.io/cat-facts/";
		SensorResponse sensorResponse = response.getBody();
//		log.info(sensorResponse.toString());
		log.info(sensorResponse.get_data_().toString());
		acSensorService.add(sensorResponse.get_data_());
		
		
		
 
		
	}
}
