# Strategy Pattern
Defines a family of algorithms, encapsulates each one, and makes them interchangeable.

In our context, imagine that we need to send the User Creation Notification only through one channel.
To do that, we can implement the Strategy Pattern to choose whether the notification will be sent by email or whatsapp based on the chose interface implementation.

First, let's define our NotificationService interface:

    public interface NotificationService {
        void sendNotification(User user);
    }
Now we can provide two implementations to NotificationService, EmailNotificationService and WhatsappNotificationService.

    @Service("whatsappNotificationService")
    public class WhatsappNotificationService implements NotificationService {
        @Override
        public void sendNotification(User user) {
            System.out.println("Sending whatsapp to: " + user.getUsername());
        }
    }

    @Service("emailNotificationService")
    public class EmailNotificationService implements NotificationService {
        @Override
        public void sendNotification(User user) {
            System.out.println("Sending email to: " + user.getEmail());
        }
    }

Notice that we defined the Bean name explicitly to the implementations. We can use Spring to choose the desired implementation based on the Bean name, as seen below:

    @Service
    @RequiredArgsConstructor
    public class UserService {
        @Qualifier("whatsappNotificationService")
        private final NotificationService notificationService;

        public void saveUser(String username, String email, String password, String zipCode) {
            // User creation code
            notificationService.sendNotification(user);
        }
    }