package com.pierre.hexagonal.application.ports.out;

import com.pierre.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);

}
