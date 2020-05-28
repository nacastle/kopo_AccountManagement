package IntegratedAccount.UI.Account;

import IntegratedAccount.Service.Account.AccountService;
import IntegratedAccount.Service.Account.AccountServiceFactory;

public abstract class BaseAccountUI implements IAccountUI {

    protected AccountService accountService;

    public BaseAccountUI() {
        accountService = AccountServiceFactory.getAccountService();
    }
}
