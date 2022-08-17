package com.mapper.service.person;

import com.mapper.dto.PersonDTO;
import com.mapper.entity.Person;
//Esto es lo que que hace de forma automatica #IPersonMapper
public class PersonMapperImp implements IPersonMapper {

	@Override
	public PersonDTO personToPersonDto(Person person) {
		if(person==null)
			return null;
		
		PersonDTO personDTO = new PersonDTO();
		personDTO.setNombre( person.getNombre() );
		personDTO.setApellidos( person.getApellidos() );
		personDTO.setEdad( person.getEdad() );
        return personDTO;
			
	
	}

}
