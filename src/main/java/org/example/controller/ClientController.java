package org.example.controller;

import org.example.dto.ClientDto;
import org.example.mapper.ClientMapper;
import org.example.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping({"/id"})
    public ClientDto getClient(@PathVariable Integer id) {
        return clientService.getClient(id);
    }

    @GetMapping
    public List<ClientDto> getAll() {
        return clientService.getAll();
    }

    @PostMapping
    public ClientDto saveClient(@RequestBody ClientDto clientDto) {
        return clientService.saveClient(clientDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.delete(id);
    }


}
