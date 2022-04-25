package kz.dar.academy.java.backend.clientcoreapi.services.client;

import kz.dar.academy.java.backend.clientcoreapi.model.ClientRequest;
import kz.dar.academy.java.backend.clientcoreapi.model.ClientResponse;
import kz.dar.academy.java.backend.clientcoreapi.repositories.ClientEntity;
import kz.dar.academy.java.backend.clientcoreapi.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        clientRequest.setClientId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ClientEntity clientEntity = modelMapper.map(clientRequest,ClientEntity.class);

        clientEntity = clientRepository.save(clientEntity);


        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);


        return clientRepository.getClientEntityBy().stream().map(client -> modelMapper.map(client,ClientResponse.class)).collect(Collectors.toList());
    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ClientEntity clientEntity = modelMapper.map(clientRequest,ClientEntity.class);

        ClientEntity dbEntity = clientRepository.getClientEntityByClientId(clientRequest.getClientId());
        clientEntity.setId(dbEntity.getId());

        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientRepository.deleteClientEntityByClientId(clientId);
    }
}
