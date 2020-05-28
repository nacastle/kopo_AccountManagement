package Account.UI.Account;

import Account.Service.Account.AccountService;
import Account.Service.Account.AccountServiceFactory;

public abstract class BaseAccountUI implements IAccountUI {

    protected AccountService accountService;

    public BaseAccountUI() {
        accountService = AccountServiceFactory.getAccountService();
    }
}
