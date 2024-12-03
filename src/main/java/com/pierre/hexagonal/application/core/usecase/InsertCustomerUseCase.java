package com.pierre.hexagonal.application.core.usecase;

import com.pierre.hexagonal.application.core.domain.Customer;
import com.pierre.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.pierre.hexagonal.application.ports.out.FindAdressByZipCodeOutputPort;
import com.pierre.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.pierre.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort,
                                InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort){

        this.findAdressByZipCodeOutputPort = findAdressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var adress = findAdressByZipCodeOutputPort.find(zipCode);
        customer.setAdress(adress);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }

}
