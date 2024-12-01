package com.pierre.hexagonal.application.ports.out;

import com.pierre.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);

}
