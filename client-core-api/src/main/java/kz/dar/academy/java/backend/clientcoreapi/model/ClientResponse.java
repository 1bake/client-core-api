package kz.dar.academy.java.backend.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    @NotNull
    private String clientId;
    @NotNull
    private String clientEmail;
    @NotNull
    @Size(min = 2, max = 20, message = "Name must be more than 2 and less than 20")
    private String clientName;
    @NotNull
    @Size(min = 2, max = 20, message = "Name must be more than 2 and less than 20")
    private String clientSurname;


}
