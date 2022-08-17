package com.mapper.test;

import java.util.ArrayList;
import java.util.List;

import com.mapper.dto.ClienteDTO;
import com.mapper.dto.PersonDTO;
import com.mapper.entity.Person;
import com.mapper.service.client.IClientMapper;
import com.mapper.service.person.IPersonMapper;

public class MapStructMain {

	public static void main(String[] args) {
		Person persona = new Person("pepe", "perez", 20);

		PersonDTO personaDto = IPersonMapper.INSTANCIA.personToPersonDto(persona);
		ClienteDTO clienteDTO = IClientMapper.INSTANICA.personToClientDto(persona);
		Person person = IClientMapper.INSTANICA.clientDtoToPerson(clienteDTO);
		
		System.out.println(personaDto.toString());
		System.out.println(clienteDTO.toString());
		System.out.println(person.toString());
		
		//
		List<Person> lPerson = new ArrayList<Person>();
		lPerson.add(new Person("pepe", "perez", 20));
		lPerson.add(new Person("ramon", "rata", 20));
		lPerson.add(new Person("juan", "sanz", 20));
		lPerson.add(new Person("pedro", "mark", 20));
		List<ClienteDTO> lClientDto = IClientMapper.INSTANICA.lPersonToLClientDto(lPerson);
		lClientDto.forEach(System.out::println);
	}

}
