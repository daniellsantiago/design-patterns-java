package com.daniellsantiago.designpatterns.infrastructure.gateway;

import com.daniellsantiago.designpatterns.application.gateway.MyCepApiGateway;
import com.daniellsantiago.designpatterns.domain.Address;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class MyCepApiGatewayImpl implements MyCepApiGateway {

    @Override
    public Optional<Address> findAddressByZipCode(String zipCode) {
        var address = Address.builder()
          .zip(zipCode)
          .state("Mocked state")
          .street("Mocked street")
          .city("Mocked city")
          .build();
        return Optional.of(address);
    }
}
