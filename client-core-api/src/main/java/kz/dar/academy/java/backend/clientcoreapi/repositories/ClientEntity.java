package kz.dar.academy.java.backend.clientcoreapi.repositories;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "client_table")

public class ClientEntity {


    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String clientId;
    @Column(nullable = false,length = 50)
    private String clientEmail;
    @Column(nullable = false,length = 50)
    private String clientName;
    @Column(nullable = false,length = 50)
    private String clientSurname;



}
