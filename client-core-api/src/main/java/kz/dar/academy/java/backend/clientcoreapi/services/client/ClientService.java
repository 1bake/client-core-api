package kz.dar.academy.java.backend.clientcoreapi.services.client;

import kz.dar.academy.java.backend.clientcoreapi.model.ClientRequest;
import kz.dar.academy.java.backend.clientcoreapi.model.ClientResponse;

import java.util.List;

public interface ClientService {


    ClientResponse createClient(ClientRequest clientRequest);

    List<ClientResponse> getAllClients();

    ClientResponse updateClient(ClientRequest clientRequest);

    void deleteClientById(String clientId);


}
