package kz.dar.academy.java.backend.clientcoreapi.controllers;

import kz.dar.academy.java.backend.clientcoreapi.model.ClientRequest;
import kz.dar.academy.java.backend.clientcoreapi.model.ClientResponse;
import kz.dar.academy.java.backend.clientcoreapi.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest){
        return clientService.createClient(clientRequest);
    }

    @PutMapping
    public ClientResponse updateClient(@RequestParam String clientId, @RequestBody ClientRequest clientRequest){
        clientRequest.setClientId(clientId);

        return clientService.updateClient(clientRequest);

    }

//    @GetMapping
//    public PostResponse getPostById(RequestParam String postId){
//        return postService.getPostById(postId);
//    }

    @GetMapping
    public List<ClientResponse> getAllClients(){
        return clientService.getAllClients();
    }

    @DeleteMapping
    public void deleteClient(@RequestParam String clientId){
        clientService.deleteClientById(clientId);
    }

}
