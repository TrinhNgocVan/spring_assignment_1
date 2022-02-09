package com.aptech.t2004e.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aptech.t2004e.config.BaseDto;
import com.aptech.t2004e.entity.District;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



@Data
@SuperBuilder
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StreetDto  extends BaseDto{
	private long id ;
	private String name ;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate  foundingDate ;
	private String description ;
	private String status ;
	private DistrictDto district ;
	/*
	 * 
	 */
	private String createdBy ;
	private LocalDateTime createdAt ;
	private String updatedBy ;
	private LocalDateTime updatedAt ;
}
