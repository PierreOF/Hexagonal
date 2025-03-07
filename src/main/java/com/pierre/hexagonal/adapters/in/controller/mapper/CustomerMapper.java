package com.pierre.hexagonal.adapters.in.controller.mapper;

import com.pierre.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.pierre.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.pierre.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "adress",ignore = true)
    @Mapping(target = "validCpf",ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
