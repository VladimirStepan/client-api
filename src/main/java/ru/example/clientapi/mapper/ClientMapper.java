package ru.example.clientapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.example.clientapi.dto.ClientDTO;
import ru.example.clientapi.dto.ContactDTO;
import ru.example.clientapi.entity.Client;
import ru.example.clientapi.entity.Contact;

@Component
@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDto(Client client);
    Client toEntity(ClientDTO clientDTO);

    @Mapping(target = "type", expression = "java(contact.getType().name())")
    ContactDTO toDto(Contact contact);
}
