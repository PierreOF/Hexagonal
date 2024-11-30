package com.pierre.hexagonal.adapters.out.repository.entity;

import com.pierre.hexagonal.application.core.domain.Adress;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;

    private AdressEntity adressEntity;

    private String cpf;

    private Boolean isValidCpf;

    private String name;

}
