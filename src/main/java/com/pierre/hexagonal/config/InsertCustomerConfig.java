package com.pierre.hexagonal.config;

import com.pierre.hexagonal.adapters.out.FindAdressByZipCodeAdapter;
import com.pierre.hexagonal.adapters.out.InsertCustomerAdapter;
import com.pierre.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {


    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAdressByZipCodeAdapter findAdressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ){
        return new InsertCustomerUseCase(findAdressByZipCodeAdapter,insertCustomerAdapter);
    }

}
