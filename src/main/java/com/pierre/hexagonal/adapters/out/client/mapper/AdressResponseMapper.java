package com.pierre.hexagonal.adapters.out.client.mapper;

import com.pierre.hexagonal.adapters.out.client.response.AdressResponse;
import com.pierre.hexagonal.application.core.domain.Adress;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
@Component
public interface AdressResponseMapper {

    Adress toAdress(AdressResponse adressResponse);
}
