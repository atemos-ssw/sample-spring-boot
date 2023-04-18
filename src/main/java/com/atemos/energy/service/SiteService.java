package com.atemos.energy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atemos.energy.dao.SiteDto;
import com.atemos.energy.repository.SiteRepository;

@Service
public class SiteService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private SiteRepository siteRepository;
	
	public Optional<SiteDto> findByIdx(int idx){ 
		Optional<SiteDto>	 site = siteRepository.findById(idx);
		return site;
		
	}
	public Optional<SiteDto> findBySiteId(int site_id){
		Optional<SiteDto> site = siteRepository.findBySiteId(site_id);
		return site;
	}
	public List<SiteDto> findAll(){
		List<SiteDto> site = siteRepository.findAll();
		logger.info(site.toString());
		return site;
	}
	
	public SiteDto add(SiteDto siteDto) {
		siteRepository.save(siteDto);
		return siteDto;
	}
	 
}
