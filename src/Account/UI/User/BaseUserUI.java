package Account.UI.User;

import Account.Service.UserService;
import Account.Service.UserServiceFactory;

public abstract class BaseUserUI implements IUserUI {

    protected UserService userService;

    public BaseUserUI() {
        userService = UserServiceFactory.getUserService();

    }
}
