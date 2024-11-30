package com.pierre.hexagonal.application.ports.out;

import com.pierre.hexagonal.application.core.domain.Adress;

public interface FindAdressByZipCodeOutputPort {

    Adress find(String zipCode);

}
