package ru.example.clientapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.clientapi.dto.ClientDTO;
import ru.example.clientapi.dto.ContactDTO;
import ru.example.clientapi.dto.ContactRequest;
import ru.example.clientapi.entity.Client;
import ru.example.clientapi.service.ClientService;
import ru.example.clientapi.service.ContactService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<?> getClient(@RequestParam int id){
        Optional<Client> clientEntity = clientService.findClientById(id);
        if(clientEntity.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(clientEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clientEntity);
        }
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createdClient(clientDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping("/{id}/contacts")
    public ResponseEntity<ClientDTO> addContact(@PathVariable int id, @Valid @RequestBody ContactRequest contactRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.addContact(id, contactRequest));
    }

    @GetMapping("/{id}/contacts")
    public ResponseEntity<List<ContactDTO>> getContacts(@PathVariable int id) {
        return ResponseEntity.ok(contactService.getContactsByClientId(id));
    }

    // Получение списка контактов заданного типа (например, PHONE/EMAIL) для клиента
    @GetMapping("/{clientId}/contacts/{type}")
    public List<ContactDTO> getContactsByTypeAndClientId(@PathVariable int clientId, @PathVariable String type) {
        return contactService.getContactsByTypeAndClientId(clientId, type.toUpperCase());
    }
}
