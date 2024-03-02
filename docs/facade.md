# Facade Pattern
The Facade design pattern is a structural pattern that provides a simplified interface to a set of interfaces in a subsystem, making it easier to use and understand. It involves creating a higher-level interface that makes the subsystem easier to use for clients, hiding the complexities of the underlying components.

To clarify It, imagine we need to save a User and Its Address. In order to find an Address, we have to consume an external API passing the user zipcode.
In case of failure while consuming the address, we could call a secondary API to give another try.

In order to facilitate this logic and avoid code duplicity, we can create a Facade class that wraps both calls and return an Address:

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