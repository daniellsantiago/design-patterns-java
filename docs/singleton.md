# Singleton Pattern
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