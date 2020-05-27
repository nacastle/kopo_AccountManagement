package Account.UI.Account;

import Account.UI.ExitUI;
import Account.VO.AccountVO;
import Account.Service.AccountService;
import Account.VO.UserVO;

import java.util.Scanner;

public class DeleteAccountUI extends BaseAccountUI {
    //Todo list: 특정 계좌 삭제

    Scanner sc = new Scanner(System.in);

    public void accountExecute(UserVO userVO) throws Exception {

        AccountService accountService = new AccountService();

        System.out.print(">삭제할 계좌의 게좌번호를 입력하세요 : ");
        int tempAccountNumber = sc.nextInt();
        sc.nextLine();

        AccountVO accountVO = accountService.selectAccountByAccountNumber(userVO, tempAccountNumber);

        if (accountVO == null) {
            System.out.println("조회되는 계좌가 없습니다.");
            new ExitUI().exitUI();
        } else {
            accountService.deleteAccount(userVO, tempAccountNumber);
            System.out.printf("'%s' 계좌가 삭제되었습니다.\n", tempAccountNumber);
        }

    }

}
