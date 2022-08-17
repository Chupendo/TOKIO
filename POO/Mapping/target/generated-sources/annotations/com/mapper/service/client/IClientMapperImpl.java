package com.mapper.service.client;

import com.mapper.dto.ClienteDTO;
import com.mapper.entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-25T17:51:13+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
public class IClientMapperImpl implements IClientMapper {

    @Override
    public ClienteDTO personToClientDto(Person person) {
        if ( person == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setNombreCliente( person.getNombre() );
        clienteDTO.setApellidosCliente( person.getApellidos() );

        return clienteDTO;
    }

    @Override
    public Person clientDtoToPerson(ClienteDTO client) {
        if ( client == null ) {
            return null;
        }

        Person person = new Person();

        person.setNombre( client.getNombreCliente() );
        person.setApellidos( client.getApellidosCliente() );

        return person;
    }

    @Override
    public List<ClienteDTO> lPersonToLClientDto(List<Person> person) {
        if ( person == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( person.size() );
        for ( Person person1 : person ) {
            list.add( personToClientDto( person1 ) );
        }

        return list;
    }
}
