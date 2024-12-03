package com.pierre.hexagonal.config;

import com.pierre.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.pierre.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {


    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findAdressByZipCodeAdapter
    ){
        return new FindCustomerByIdUseCase(findAdressByZipCodeAdapter);
    }

}
