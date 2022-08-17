package com.mapper.service.client;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mapper.dto.ClienteDTO;
import com.mapper.entity.Person;

@Mapper
public interface IClientMapper {

	IClientMapper INSTANICA = Mappers.getMapper(IClientMapper.class);
	
	@Mapping(source = "nombre", target = "nombreCliente")
	@Mapping(source = "apellidos", target = "apellidosCliente")
	ClienteDTO personToClientDto(Person person);
	
	@Mapping(source = "nombreCliente", target = "nombre")
	@Mapping(source = "apellidosCliente", target = "apellidos")
	@Mapping(target = "edad",ignore = true)
	Person clientDtoToPerson(ClienteDTO client);
	
	
	@Mapping(source = "nombre", target = "nombreCliente")
	@Mapping(source = "apellidos", target = "apellidosCliente")
	List<ClienteDTO> lPersonToLClientDto(List<Person> person);
}
