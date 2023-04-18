package com.atemos.energy.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atemos.energy.dao.BasicResponse;
import com.atemos.energy.dao.SiteDto;
import com.atemos.energy.service.SiteService;

import lombok.RequiredArgsConstructor;

@RestController
@ResponseBody
@RequestMapping("/site") 
public class SiteController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private  SiteService siteService;
 
	@GetMapping(value="/all", produces = "application/json")
	public ResponseEntity<List<Map<String,String>>> getIndexController() {
		HttpHeaders headers = new HttpHeaders(); 
	    headers.setContentType(MediaType.APPLICATION_JSON); 
	    
		List<SiteDto> siteDto = siteService.findAll();
		Map<String, String> map = new HashMap<>();
		map.put("a1", "v1");
		map.put("a2", "v1");
		List<Map<String,String>> l = new ArrayList<>();
		l.add(map);l.add(map);
		
		ResponseEntity<Object> responseEntity = null; 
		return ResponseEntity.ok().headers(headers).body(l);
	}
	
	@GetMapping(value="/all1", produces = "application/json")
	public ResponseEntity<BasicResponse> getAll() {
		HttpHeaders headers = new HttpHeaders(); 
	    headers.setContentType(MediaType.APPLICATION_JSON); 
	    List<SiteDto> siteDto = siteService.findAll();


	    BasicResponse response = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(new ArrayList<>(siteDto)).build();
	    return ResponseEntity.ok().body(response);
//	    return BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(siteDto).build();
		  
	}
	 
   
	 
	
//	https://data-make.tistory.com/710
 
	@GetMapping(value="/{id}")
	public ResponseEntity<?> getSiteId(@PathVariable int id){
		Optional<SiteDto> siteDto = siteService.findBySiteId(id);
	
		
		if(siteDto.isEmpty()) {
			logger.info("data empty");
			return new ResponseEntity<>(null, HttpStatus.OK);	
		}else {
			logger.info("data is " + siteDto);
			return new ResponseEntity<>(siteDto.get(), HttpStatus.OK);
		}
	}
}
