package IntegratedAccount.Service.Account;

public class AccountServiceFactory {

    private static AccountService accountService = null;

    public static AccountService getAccountService() {

        if(accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }
}
