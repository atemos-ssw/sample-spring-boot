package com.atemos.energy.repository; 
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atemos.energy.dao.SiteDto;

public interface SiteRepository extends JpaRepository<SiteDto, Integer>{

	public Optional<SiteDto>  findByIdx(int idx);
	public Optional<SiteDto> findBySiteId(int site_id);
	public List<SiteDto> findAll();
}
