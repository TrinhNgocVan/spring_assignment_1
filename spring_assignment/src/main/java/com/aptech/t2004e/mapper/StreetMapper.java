package com.aptech.t2004e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aptech.t2004e.dto.DistrictDto;
import com.aptech.t2004e.dto.StreetDto;
import com.aptech.t2004e.entity.District;
import com.aptech.t2004e.entity.Street;

@Mapper(componentModel = "spring")
public interface StreetMapper {
	StreetDto entityToDto (Street street);
	Street dtoToEntity (StreetDto streetDto);
	@Mapping(target = "streets" , expression = "java(null)")
	DistrictDto districtToDistrictDto(District district);
}
