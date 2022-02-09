package com.aptech.t2004e.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.aptech.t2004e.dto.StreetDto;
import com.aptech.t2004e.entity.Street;


@Component
public class StreetSpecification {
	public Specification<Street> filter(final  StreetDto criteria ){
		return (root , query , cb) -> { 
			List<Predicate> predicates = new ArrayList<>();	
			if(!criteria.getDistrict().getName().isBlank() && !criteria.getDistrict().getName().isEmpty()) {
				predicates.add(cb.like(cb.upper(root.join("district").get("name")), "%" +criteria.getDistrict().getName().trim().toUpperCase()+"%"));
			}
			if(!criteria.getName().isBlank()  &&  !criteria.getName().isEmpty()) {
				predicates.add(cb.like(cb.upper(root.get("name")), "%" +criteria.getName().trim().toUpperCase()+"%"));
			}
			return cb.and(predicates.stream().toArray(Predicate[] :: new));
		};
	}
}