package com.pierre.hexagonal.application.ports.in;

import com.pierre.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}
