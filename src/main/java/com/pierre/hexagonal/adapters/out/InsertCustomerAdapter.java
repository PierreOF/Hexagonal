package com.pierre.hexagonal.adapters.out;

import com.pierre.hexagonal.adapters.out.repository.CustomerRepository;
import com.pierre.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.pierre.hexagonal.application.core.domain.Customer;
import com.pierre.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void insert(Customer customer,String zipCode){
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
