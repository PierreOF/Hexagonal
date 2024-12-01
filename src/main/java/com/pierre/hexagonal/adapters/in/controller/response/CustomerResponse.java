package com.pierre.hexagonal.adapters.in.controller.response;

import com.pierre.hexagonal.adapters.out.client.response.AdressResponse;
import com.pierre.hexagonal.application.core.domain.Adress;
import lombok.Data;

@Data
public class CustomerResponse{

    private String name;

    private AdressResponse adress;

    private String cpf;

    private Boolean isValidCpf;


}
