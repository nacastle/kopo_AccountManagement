package Account.UI.User;

import Account.Service.User.UserService;
import Account.Service.User.UserServiceFactory;

public abstract class BaseUserUI implements IUserUI {

    protected UserService userService;

    public BaseUserUI() {
        userService = UserServiceFactory.getUserService();

    }
}
