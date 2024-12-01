package com.pierre.hexagonal.adapters.out.repository.mapper;

import com.pierre.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.pierre.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
