package com.daniellsantiago.designpatterns.application.service;

import com.daniellsantiago.designpatterns.application.gateway.CorreiosApiGateway;
import com.daniellsantiago.designpatterns.application.gateway.MyCepApiGateway;
import com.daniellsantiago.designpatterns.domain.Address;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final CorreiosApiGateway correiosApiGateway;
    private final MyCepApiGateway myCepApiGateway;

    public Optional<Address> findAddressByZipCode(String zipCode) {
        return correiosApiGateway
          .findAddressByZipCode(zipCode)
          .or(() -> myCepApiGateway.findAddressByZipCode(zipCode));
    }
}
