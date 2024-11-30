package com.pierre.hexagonal.application.core.usecase;

import com.pierre.hexagonal.application.core.domain.Customer;
import com.pierre.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class FindCustomerByIdUseCase {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort){
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found!"));
    }
}
