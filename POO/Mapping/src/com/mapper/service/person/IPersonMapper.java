package com.mapper.service.person;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mapper.dto.PersonDTO;
import com.mapper.entity.Person;

@Mapper
public interface IPersonMapper {
	
	IPersonMapper INSTANCIA = Mappers.getMapper(IPersonMapper.class);
	
	//
	PersonDTO personToPersonDto(Person person);

}
