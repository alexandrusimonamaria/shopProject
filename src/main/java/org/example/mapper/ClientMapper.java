package org.example.mapper;

import org.example.dto.ClientDto;
import org.example.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    private OrderMapper orderMapper;

    public ClientMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<ClientDto> mapListToClientDto(List<Client> clients) {
        return clients
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public ClientDto map(Client client) {

        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setNoOrder(client.getNoOrder());
        clientDto.setProductName(client.getProductName());
        clientDto.setProductPrice(client.getProductPrice());

        return clientDto;
    }

    public Client map(ClientDto clientDto) {

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNoOrder(clientDto.getNoOrder());
        client.setProductName(clientDto.getProductName());
        client.setProductPrice(clientDto.getProductPrice());
        //client.setOrders(orderMapper.mapListToOrder(clientDto.get));

        return client;
    }

}
