package com.aptech.t2004e.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.aptech.t2004e.entity.Street;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> , JpaSpecificationExecutor<Street>  {

}
