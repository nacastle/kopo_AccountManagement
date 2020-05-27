package Account.UI.Account;

import Account.Service.AccountService;
import Account.Service.AccountServiceFactory;

public abstract class BaseAccountUI implements IAccountUI {

    protected AccountService accountService;

    public BaseAccountUI() {
        accountService = AccountServiceFactory.getAccountService();
    }
}
