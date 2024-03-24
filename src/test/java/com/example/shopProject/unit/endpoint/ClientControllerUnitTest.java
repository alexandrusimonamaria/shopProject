package com.example.shopProject.unit.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.ClientController;
import org.example.dto.ClientDto;
import org.example.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientControllerUnitTest {
    private MockMvc mockMvc;
    @Mock
    private ClientService clientService;
    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void testGetAll_Success() throws Exception {
        List<ClientDto> clients = getDummyClientDtos();
        Mockito.when(clientService.getAll()).thenReturn(clients);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/client"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(clients)));
    }

    private List<ClientDto> getDummyClientDtos() {
        return new ArrayList<>(Arrays.asList(getDummyClientDtoOne(), getDummyClientDtoTwo()));
    }

    private ClientDto getDummyClientDtoOne() {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(1);
        clientDto.setProductName("Cat");
        clientDto.setProductPrice(43);

        return clientDto;
    }

    private ClientDto getDummyClientDtoTwo() {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(2);
        clientDto.setProductName("Cat");
        clientDto.setProductPrice(333);

        return clientDto;
    }

}
