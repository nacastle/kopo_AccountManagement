package Account.Service;

public class AccountServiceFactory {

    private static AccountService accountService = null;

    public static AccountService getAccountService() {

        if(accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }
}
