package com.aptech.t2004e.mapper;

import org.mapstruct.Mapper;

import com.aptech.t2004e.dto.DistrictDto;
import com.aptech.t2004e.entity.District;

@Mapper(componentModel = "spring")
public interface DistrictMapper {
	DistrictDto entityToDto (District district);
	District dtoToEntity (DistrictDto districtDto);
}
