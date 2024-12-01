package ru.example.clientapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.clientapi.dto.ClientDTO;
import ru.example.clientapi.entity.Client;
import ru.example.clientapi.mapper.ClientMapper;
import ru.example.clientapi.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    public ClientDTO createdClient(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        Client saved = clientRepository.save(client);

        return clientMapper.toDto(saved);
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();
    }

    public Optional<Client> findClientById(int id) {
        return clientRepository.findById(id);
    }
}
