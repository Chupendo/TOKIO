package com.mapper.service.person;

import com.mapper.dto.PersonDTO;
import com.mapper.entity.Person;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-25T17:51:13+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
public class IPersonMapperImpl implements IPersonMapper {

    @Override
    public PersonDTO personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setNombre( person.getNombre() );
        personDTO.setApellidos( person.getApellidos() );
        personDTO.setEdad( person.getEdad() );

        return personDTO;
    }
}
