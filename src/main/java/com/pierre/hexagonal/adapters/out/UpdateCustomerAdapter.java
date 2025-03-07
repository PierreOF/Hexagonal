package com.pierre.hexagonal.adapters.out;

import com.pierre.hexagonal.adapters.out.repository.CustomerRepository;
import com.pierre.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.pierre.hexagonal.application.core.domain.Customer;
import com.pierre.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
