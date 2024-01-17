package com.example.shopProject.unit.service;

import org.example.dto.ClientDto;
import org.example.exception.ClientNotFoundException;
import org.example.mapper.ClientMapper;
import org.example.model.Client;
import org.example.repository.ClientRepository;
import org.example.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class ClientServiceUnitTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_success() {
        Client client = getDummyClient();
        ClientDto clientDto = getDummyClientDtoOne();
        Mockito.when(clientRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(client));
        Mockito.when(clientMapper.map(client))
                .thenReturn(clientDto);

        ClientDto returnedClient = clientService.getClient(1);

        Assertions.assertEquals(returnedClient.getNoOrder(), clientDto.getNoOrder());
        Assertions.assertEquals(returnedClient.getProductName(), clientDto.getProductName());
        Assertions.assertEquals(returnedClient.getProductPrice(), clientDto.getProductPrice());
    }

    @Test
    public void testGetById_exception() {
        Mockito.when(clientRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(ClientNotFoundException.class, () -> clientService.getClient(11));
    }

    private Client getDummyClient() {
        Client client = new Client();
        client.setId(1);
        client.setNoOrder(1);
        client.setProductName("Cat");
        client.setProductPrice(33);

        return client;
    }

    private ClientDto getDummyClientDtoOne() {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(1);
        clientDto.setNoOrder(1);
        clientDto.setProductName("Cat");
        clientDto.setProductPrice(33);

        return clientDto;
    }

}
