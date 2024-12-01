package com.pierre.hexagonal.application.ports.in;

import com.pierre.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {


    void update(Customer customer, String zipCode);
}
