package com.mapper.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mapper.dto.ClienteDTO;
import com.mapper.dto.PersonDTO;
import com.mapper.entity.Person;
import com.mapper.service.client.IClientMapper;
import com.mapper.service.person.IPersonMapper;

public class MapStructTest {
	@Test
	public void testMapperPersonToPersonDto() {
		Person persona = new Person("pepe", "perez", 20);

		PersonDTO personaDto = IPersonMapper.INSTANCIA.personToPersonDto(persona);

		assertEquals("pepe", personaDto.getNombre());
		assertEquals("perez", personaDto.getApellidos());
		assertEquals(20, personaDto.getEdad());
	}

	@Test
	public void testMapperPersonToClienteDto() {
		Person persona = new Person("pepe", "perez", 20);

		ClienteDTO clienteDto = IClientMapper.INSTANICA.personToClientDto(persona);

		assertEquals("pepe", clienteDto.getNombreCliente());
		assertEquals("perez", clienteDto.getApellidosCliente());
		//assertEquals(20, clienteDto.getEdad());

	}
	
	@Test
	public void testMapperClientDtoToPerson() {
		ClienteDTO client = new ClienteDTO("Andres", "Ruiz", 29);

		Person person = IClientMapper.INSTANICA.clientDtoToPerson(client);

		assertEquals("Andres", person.getNombre());
		assertEquals("Ruiz", person.getEdad());
		assertEquals(0, person.getEdad());

	}

}
