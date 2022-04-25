package kz.dar.academy.java.backend.clientcoreapi.services.deprecated;

import kz.dar.academy.java.backend.clientcoreapi.models.ClientModel;

import java.util.List;

public interface ClientServiceOld {

    ClientModel createClient(ClientModel clientModel);
    ClientModel updateClient(String clientId,ClientModel clientModel);
    List<ClientModel> getAllClients();
    ClientModel getClientById(String clientId);
    void deleteClientById(String clientId);

}
