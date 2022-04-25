package kz.dar.academy.java.backend.clientcoreapi.services.deprecated;

import kz.dar.academy.java.backend.clientcoreapi.models.ClientModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ClientServiceOldImplOld implements ClientServiceOld {


    private static HashMap<String,ClientModel> clientMap = new HashMap<>();

    static {

        ClientModel client1 = new ClientModel(UUID.randomUUID().toString(),"Ivan","Petrov","ivan@mail.ru");
        ClientModel client2 = new ClientModel(UUID.randomUUID().toString(),"Berik","Serikov","berik@mail.ru");
        ClientModel client3 = new ClientModel(UUID.randomUUID().toString(),"Ilyas","Zhuanyshev","ilyasbek@mail.ru");


        clientMap.put(client1.getClientId(),client1);
        clientMap.put(client2.getClientId(),client2);
        clientMap.put(client3.getClientId(),client3);

    }


    @Override
    public ClientModel createClient(ClientModel clinetModel) {
        clinetModel.setClientId(UUID.randomUUID().toString());
        return clientMap.put(clinetModel.getClientId(),clinetModel);
    }

    @Override
    public ClientModel updateClient(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        return clientMap.put(clientId,clientModel);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void deleteClientById(String clientId) {

        clientMap.remove(clientId);

    }
}
