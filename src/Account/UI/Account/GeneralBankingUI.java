package Account.UI.Account;

import Account.VO.UserVO;

public class GeneralBankingUI extends BaseAccountUI {

    public void accountExecute(UserVO userVO) throws Exception {


        while (true) {
            String num = new AccountUI().chooseSubMenu();

            if (num.equals("1")) {
                new DepositUI().accountExecute(userVO);
            } else if (num.equals("2")) {
                new WithdrawUI().accountExecute(userVO);
            } else if (num.equals("3")) {
                new TransferUI().accountExecute(userVO);
            } else if (num.equals("0")) {
                System.out.println("입출금 및 이체 서비스를 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
