package com.aptech.t2004e.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.aptech.t2004e.dto.DistrictDto;
import com.aptech.t2004e.dto.StreetDto;
import com.aptech.t2004e.entity.District;

@Component
public class DistrictSpecification {
	public Specification<District> filter(final  DistrictDto criteria ){
		return (root , query , cb) -> { 
			List<Predicate> predicates = new ArrayList<>();			
			return cb.and(predicates.stream().toArray(Predicate[] :: new));
		};
	}
}
