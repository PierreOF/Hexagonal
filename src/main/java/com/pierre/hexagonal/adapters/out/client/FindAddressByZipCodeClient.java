package com.pierre.hexagonal.adapters.out.client;

import com.pierre.hexagonal.adapters.out.client.response.AdressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name= "FindAddressByZipCodeClient",
        url = "${hexagonal.client.address.url}"
)

public interface FindAddressByZipCodeClient {

    @GetMapping("/{zip}")
    AdressResponse find(@PathVariable("zip") String zipCode);

}
