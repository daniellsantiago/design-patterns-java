package com.daniellsantiago.designpatterns.application.gateway;

import com.daniellsantiago.designpatterns.domain.Address;
import java.util.Optional;

public interface MyCepApiGateway {
    Optional<Address> findAddressByZipCode(String zipCode);
}
