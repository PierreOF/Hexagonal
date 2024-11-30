package com.pierre.hexagonal.application.core.usecase;

import com.pierre.hexagonal.application.core.domain.Customer;
import com.pierre.hexagonal.application.ports.out.FindAdressByZipCodeOutputPort;
import com.pierre.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort,
                                InsertCustomerOutputPort insertCustomerOutputPort){

        this.findAdressByZipCodeOutputPort = findAdressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer,String zipCode){
        var adress = findAdressByZipCodeOutputPort.find(zipCode);
        customer.setAdress(adress);
    }

}
