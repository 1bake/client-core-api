package kz.dar.academy.java.backend.clientcoreapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {

    @NotNull
    private String clientId;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;


}
