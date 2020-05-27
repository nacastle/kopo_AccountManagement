package Account.UI.Account;

import Account.UI.ExitUI;
import Account.VO.AccountVO;
import Account.VO.UserVO;

import java.util.List;

public class SelectAllAccountUI extends BaseAccountUI {
    //Todo list: 전체 계좌정보 조회 (잔금까지)


    public void accountExecute(UserVO userVO) throws Exception {
        List<AccountVO> list = accountService.selectAllAccount(userVO);
        if (list == null) {

            System.out.println("조회할 계좌가 없습니다.");
            new ExitUI().exitUI();
        }

        AccountUI.showHead();
        for (AccountVO accountVO : list) {
            String id = accountVO.getId();
            String nickname = accountVO.getNickname();
            int accountNumber = accountVO.getAccountNumber();
            String bank = accountVO.getBank();
            String accountOwner = accountVO.getAccountOwner();
            long balance = accountVO.getBalance();

            System.out.printf("%-10s %-15s %-15d %-10s %-10s %-20d\n", id, nickname, accountNumber, bank, accountOwner, balance);
        }


    }



/*
    public void selectAllAccountUI(UserVO userVO) {

        DAO accountDAO = new DAO();

        if (accountDAO.selectAllAccountDAO(userVO) == null) {
            System.out.println("조회할 계좌가 없습니다.");
            new ExitUI().exitUI();
        } else {
            UI accountUI = new UI();
            accountUI.showHead();
            for (int i = 0; i < accountDAO.selectAllAccountDAO(userVO).size(); i++) {
                String id = accountDAO.selectAllAccountDAO(userVO).get(i).getId();
                String nickname = accountDAO.selectAllAccountDAO(userVO).get(i).getNickname();
                int accountNumber = accountDAO.selectAllAccountDAO(userVO).get(i).getAccountNumber();
                String bank = accountDAO.selectAllAccountDAO(userVO).get(i).getBank();
                String accountOwner = accountDAO.selectAllAccountDAO(userVO).get(i).getAccountOwner();
                long balance = accountDAO.selectAllAccountDAO(userVO).get(i).getBalance();

                System.out.printf("%-10s %-15s %-15d %-10s %-10s %-20d\n", id, nickname, accountNumber, bank, accountOwner, balance);

            }
        }
*/

}

