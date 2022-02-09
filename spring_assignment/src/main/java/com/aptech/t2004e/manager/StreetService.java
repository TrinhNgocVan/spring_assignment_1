package com.aptech.t2004e.manager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aptech.t2004e.config.PageDto;
import com.aptech.t2004e.dto.StreetDto;
import com.aptech.t2004e.entity.Street;
import com.aptech.t2004e.mapper.StreetMapper;
import com.aptech.t2004e.repository.StreetRepository;
import com.aptech.t2004e.specification.StreetSpecification;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class StreetService {
	@Autowired
	private StreetRepository streetRepo ;
	@Autowired
	private StreetSpecification streetSpec ;
	@Autowired
	private StreetMapper streetMapper ;
	
	public PageDto search (StreetDto criteria) {
		log.info("process = search street , criteria = {}", criteria);
		Page<Street> page = streetRepo.findAll(streetSpec.filter(criteria),PageRequest.of(0, 0,Sort.by("createdAt").descending()));
		return PageDto.builder()
					.content(page.getContent().stream().map(streetMapper :: entityToDto).collect(Collectors.toList()))
					.number(page.getNumber())
					.numberOfElements(page.getNumberOfElements())
					.size(page.getSize())
					.page(page.getNumber())
					.totalPages(page.getTotalPages())
					.totalElements(page.getTotalElements())
					.build();
	}
	public List<StreetDto> getAll(StreetDto  criteria){
			return streetRepo.findAll(streetSpec.filter(criteria)).stream().map(streetMapper :: entityToDto).collect(Collectors.toList());
	}
	public StreetDto save(StreetDto streetDto){
		Street street = streetMapper.dtoToEntity(streetDto);
		if(street != null ) {
			return Optional.ofNullable(streetRepo.save(street)).map(streetMapper :: entityToDto).orElse(null);
		}else {
			return null ;
		}
	}
}
