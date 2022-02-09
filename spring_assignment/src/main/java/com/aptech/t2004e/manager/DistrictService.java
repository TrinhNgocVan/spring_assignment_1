package com.aptech.t2004e.manager;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptech.t2004e.dto.DistrictDto;
import com.aptech.t2004e.mapper.DistrictMapper;
import com.aptech.t2004e.repository.DistrictRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@Transactional
public class DistrictService {
	@Autowired
	private DistrictRepository districtRepo ;
//	@Autowired
//	private DistrictSpecification districtSpec ;
	@Autowired
	private DistrictMapper districtMapper ;
	public List<DistrictDto> getAll(){
		log.info("process = get all district ");
		return districtRepo.findAll().stream().map(districtMapper :: entityToDto).collect(Collectors.toList());
}
}
