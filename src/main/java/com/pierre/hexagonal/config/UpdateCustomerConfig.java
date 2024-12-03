package com.pierre.hexagonal.config;

import com.pierre.hexagonal.adapters.out.FindAdressByZipCodeAdapter;
import com.pierre.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.pierre.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.pierre.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {


    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAdressByZipCodeAdapter findAdressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAdressByZipCodeAdapter,updateCustomerAdapter);
    }

}
