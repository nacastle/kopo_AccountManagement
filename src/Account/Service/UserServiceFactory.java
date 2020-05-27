package Account.Service;

public class UserServiceFactory {

    private static UserService userService = null;

    public static UserService getUserService() {

        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
}
