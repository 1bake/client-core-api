package kz.dar.academy.java.backend.clientcoreapi.controllers;


import kz.dar.academy.java.backend.clientcoreapi.models.ClientModel;
import kz.dar.academy.java.backend.clientcoreapi.services.deprecated.ClientServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/old/client")
public class HomeController {


    ClientServiceOld clientServiceOld;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String check(){
        return "Client-core-api is working!"+env.getProperty("local.server.port");
    }


    @PostMapping
    public ClientModel createPost(@Valid @RequestBody ClientModel clientModel) {
        return clientServiceOld.createClient(clientModel);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientServiceOld.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientServiceOld.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ClientModel updateClient(@PathVariable String clientId, @Valid @RequestBody ClientModel clientModel) {
        return clientServiceOld.updateClient(clientId,  clientModel);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
        clientServiceOld.deleteClientById(clientId);
        return new ResponseEntity<>("Success deleted", HttpStatus.OK);
    }

}
