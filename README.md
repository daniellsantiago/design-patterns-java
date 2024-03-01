# design-patterns-java

Design patterns are reusable solutions to common problems that arise in software design. They provide a way to create modular, maintainable, and scalable software by capturing best practices and proven design principles. 

In this project, I'm gonna update my study notes about some of the most used Design Patterns and Its implementation on a Spring boot API context.

## Singleton Pattern
Ensures a class has only one instance and provides a global point of access to it.

In Spring Framework, a Singleton is a special type of bean that is only instantiated once and shared across the entire application. This means that any component or class that depends on a Singleton bean will receive the same instance of that bean.

To create a Singleton bean in Spring, you can use either any annotation that extends @Component or @Bean Itself. Here's an example using the @Repository annotation:

    @Repository
    @NoArgsConstructor
    public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();
        @Override
        public User save(User user) {
            users.add(user);
            return user;
        }
        @Override
        public Optional<User> findUserByUsername(String username) {
            return users.stream()
              .filter(user -> user.getUsername().equals(username))
              .findFirst();
        }
    }
As you can see, the code above represents an in-memory database. Therefore, It needs to have only one instance across all the application (Singleton) to ensure that the data can be shared to any Class that injects It.

## Facade Pattern
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

## Observer Pattern
Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. 

## Strategy Pattern
Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
