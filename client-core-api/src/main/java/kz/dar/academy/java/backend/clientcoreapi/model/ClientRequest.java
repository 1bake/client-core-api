package kz.dar.academy.java.backend.clientcoreapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    private String clientId;
    private String clientEmail;
    private String clientName;
    private String clientSurname;


}
