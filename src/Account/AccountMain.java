package Account;

import Account.UI.Admin.AdminUI;

public class AccountMain {

    public static void main(String[] args) {


        try {
            new AdminUI().adminExecute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

