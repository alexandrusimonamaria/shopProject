package org.example.service;

import org.example.dto.ClientDto;
import org.example.exception.ClientNotFoundException;
import org.example.mapper.ClientMapper;
import org.example.model.Client;
import org.example.model.Product;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDto> getAll() {
        List<Client> allClients = clientRepository.findAll();
        return clientMapper.mapListToClientDto(allClients);
    }

    public ClientDto getClient(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + "doesn't exist."));
        return clientMapper.map(client);
    }

    public ClientDto saveClient(ClientDto clientDto) {
        Client dbClient = clientRepository.save(clientMapper.map(clientDto));
        return clientMapper.map(dbClient);
    }


    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
