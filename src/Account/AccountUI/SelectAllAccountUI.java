package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import User.UserVO.UserVO;

public class SelectAllAccountUI {
    //Todo list: 전체 계좌정보 조회 (잔금까지)



    public void selectAllAcountUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();

        if (accountDAO.selectAllAccountDAO(userVO) == null){
            System.out.println("조회할 계좌가 없습니다.");
            new ExitUI().exitUI();
            System.exit(0);
        } else {
            AccountUI accountUI = new AccountUI();
            accountUI.showHead();
            for (int i = 0; i <accountDAO.selectAllAccountDAO(userVO).size(); i++ ) {
                String id = accountDAO.selectAllAccountDAO(userVO).get(i).getId();
                String nickname = accountDAO.selectAllAccountDAO(userVO).get(i).getNickname();
                int accountNumber = accountDAO.selectAllAccountDAO(userVO).get(i).getAccountNumber();
                String bank = accountDAO.selectAllAccountDAO(userVO).get(i).getBank();
                String accountOwner = accountDAO.selectAllAccountDAO(userVO).get(i).getAccountOwner();
                long balance = accountDAO.selectAllAccountDAO(userVO).get(i).getBalance();

                System.out.printf("%-10s %-15s %-15d %-10s %-10s %-20d\n",id, nickname,accountNumber,bank,accountOwner,balance);

            }
        }

    }

}
