package com.pierre.hexagonal.application.core.usecase;

import com.pierre.hexagonal.application.core.domain.Customer;
import com.pierre.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.pierre.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.pierre.hexagonal.application.ports.out.FindAdressByZipCodeOutputPort;
import com.pierre.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.data.mongodb.repository.Update;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAdressByZipCodeOutputPort = findAdressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        var adress = findAdressByZipCodeOutputPort.find(zipCode);
        customer.setAdress(adress);
        updateCustomerOutputPort.update(customer);

    }
}
