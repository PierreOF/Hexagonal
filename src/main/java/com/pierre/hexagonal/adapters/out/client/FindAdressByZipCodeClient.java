package com.pierre.hexagonal.adapters.out.client;

import com.pierre.hexagonal.adapters.out.client.response.AdressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name= "FindAdressByZipCodeClient",
        url = "${hexagonal.client.adress.url}"
)

public interface FindAdressByZipCodeClient {

    @GetMapping("/{zip}")
    AdressResponse find(@PathVariable("zipCode") String zipCode);

}