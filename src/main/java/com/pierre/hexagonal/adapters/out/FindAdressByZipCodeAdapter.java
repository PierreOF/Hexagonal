package com.pierre.hexagonal.adapters.out;

import com.pierre.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.pierre.hexagonal.adapters.out.client.mapper.AdressResponseMapper;
import com.pierre.hexagonal.application.core.domain.Adress;
import com.pierre.hexagonal.application.ports.out.FindAdressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAdressByZipCodeAdapter implements FindAdressByZipCodeOutputPort {

    @Autowired
    private AdressResponseMapper adressResponseMapper;

    @Autowired
    private FindAddressByZipCodeClient findAdressByZipCodeClient;

    @Override
    public Adress find(String zipCode){
        var adressResponse = findAdressByZipCodeClient.find(zipCode);
        return adressResponseMapper.toAdress(adressResponse);
    }



}
