package IntegratedAccount.UI.User;

import IntegratedAccount.Service.User.UserService;
import IntegratedAccount.Service.User.UserServiceFactory;

public abstract class BaseUserUI implements IUserUI {

    protected UserService userService;

    public BaseUserUI() {
        userService = UserServiceFactory.getUserService();

    }
}
