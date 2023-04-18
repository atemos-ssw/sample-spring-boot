package com.atemos.energy.dao;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
@Entity(name = "site")
@AllArgsConstructor
public class SiteDto {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int idx;
	@Column(name = "site_id")
	private int siteId;
	
//	protected Site(Integer idx, Integer site_id) {
//		this.idx = idx;
//		this.site_id = site_id;
//	}

//	@Builder
//	public SiteDto(int idx, int siteId) {
//		this.idx = idx;
//		this.siteId  = siteId;
//	}
	
//	@Override
//	public String toString() {
//		return String.format("idx = %02d, site_id = %02d", this.idx, this.siteId);
//	} 
	
	
}
