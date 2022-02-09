package com.aptech.t2004e.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aptech.t2004e.dto.StreetDto;
import com.aptech.t2004e.manager.DistrictService;
import com.aptech.t2004e.manager.StreetService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class StreetController {
	@Autowired
	private StreetService streetService;
	@Autowired
	private DistrictService districtService ;
	@GetMapping("/streets")
	public ResponseEntity<?> gets(HttpServletRequest request){
		log.info("get all street ");
		return ResponseEntity.ok(streetService.getAll(StreetDto.builder().build()));
	}
	@PostMapping("/streets")
	public ResponseEntity<?> gets(@RequestBody StreetDto criteria  ){
		log.info("get all street with , criteria =  {}", criteria);
		if(criteria.getPage() != null && criteria.getSize() != null ) {
			return ResponseEntity.ok(streetService.search(criteria));
		}else {
			return ResponseEntity.ok(streetService.getAll(criteria));
		}
	}
	@PostMapping("/street")
	public ResponseEntity<?> createStreet(@RequestBody StreetDto street ){
		log.info("create Street , street =  {}", street);
		return ResponseEntity.status(HttpStatus.CREATED).body(streetService.save(street));
		
	}
	@GetMapping("/districts")
	public ResponseEntity<?> getDistricts(HttpServletRequest request){
		log.info("get all distric ");
		return ResponseEntity.ok(districtService.getAll());
	}
	
	
}
