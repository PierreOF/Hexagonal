package com.pierre.hexagonal.application.ports.in;

import com.pierre.hexagonal.application.core.domain.Customer;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

@Component
public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
