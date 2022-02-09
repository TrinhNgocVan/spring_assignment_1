package com.aptech.t2004e.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.aptech.t2004e.config.BaseDto;
import com.aptech.t2004e.entity.Street;

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
public class DistrictDto  extends BaseDto{
	private long id ;
	private String name ;
	private List<StreetDto> streets ;	
	
	/*
	 * 
	 */
	private String createdBy ;
	private LocalDateTime createdAt ;
	private String updatedBy ;
	private LocalDateTime updatedAt ;	
}
