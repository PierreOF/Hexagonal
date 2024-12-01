package com.pierre.hexagonal.application.ports.in;

import com.pierre.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
