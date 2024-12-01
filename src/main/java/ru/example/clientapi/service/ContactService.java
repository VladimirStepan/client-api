package ru.example.clientapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.clientapi.dto.ClientDTO;
import ru.example.clientapi.dto.ContactDTO;
import ru.example.clientapi.dto.ContactRequest;
import ru.example.clientapi.entity.Client;
import ru.example.clientapi.entity.Contact;
import ru.example.clientapi.entity.ContactType;
import ru.example.clientapi.mapper.ClientMapper;
import ru.example.clientapi.repository.ClientRepository;
import ru.example.clientapi.repository.ContactRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    public ClientDTO addContact(int clientId, ContactRequest contactRequest) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        Contact contact = new Contact();
        contact.setClient(client);
        contact.setType(ContactType.valueOf(contactRequest.getType().toUpperCase()));
        contact.setValue(contactRequest.getValue());

        contactRepository.save(contact);
        return clientMapper.toDto(client);
    }

    public List<ContactDTO> getContactsByClientId(int id) {
        return contactRepository.findByClientId(id).stream()
                .map(clientMapper::toDto)
                .toList();
    }

    public List<ContactDTO> getContactsByTypeAndClientId(int clientId, String type) {
        clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        ContactType contactType;
        try {
            contactType = ContactType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid contact type: " + type);
        }

        List<Contact> contacts = contactRepository.findByClientIdAndType(clientId, contactType);
        return contacts.stream()
                .map(clientMapper::toDto)
                .toList();
    }
}
