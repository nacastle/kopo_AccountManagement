package IntegratedAccount.UI.Account;

import IntegratedAccount.Service.Account.AccountService;
import IntegratedAccount.UI.zExtra.ExitUI;
import IntegratedAccount.VO.AccountVO;
import IntegratedAccount.VO.UserVO;

import java.util.Scanner;

public class WithdrawUI extends BaseAccountUI {
    //Todo list: 출금 기능 (뭘 받아서 DAO에 어떤 메소드를 쓸거임)

    Scanner sc = new Scanner(System.in);

    public void accountExecute(UserVO userVO) throws Exception {

        AccountService accountService = new AccountService();
        System.out.println("---------------------------------");
        System.out.println("\t출금 서비스 ");
        System.out.println("---------------------------------");


        int tempAccountNumber = 0;
        long originalBalance = 0;
        long withdrawAmount = 0;
        AccountVO accountVO = null;

        System.out.print(">출금할 계좌번호를 입력하세요 : ");
        tempAccountNumber = sc.nextInt();
        sc.nextLine();

        accountVO = accountService.selectAccountByAccountNumber(userVO, tempAccountNumber);

        if (accountVO == null) {
            System.out.println("조회되는 계좌가 없습니다.");
            System.out.println("출금 서비스를 종료합니다.");
        } else {
            System.out.print(">출금할 금액을 입력하세요 : ");
            withdrawAmount = sc.nextLong();
            sc.nextLine();
            originalBalance = accountVO.getBalance();
        }

        if (withdrawAmount > 0) {

            if (originalBalance < withdrawAmount) {
                System.out.println("잔액을 초과합니다.");
                new ExitUI().exitUI();
            } else {
                accountService.withdraw(userVO, originalBalance, withdrawAmount, tempAccountNumber);
                System.out.printf("%d원이 출금되었습니다.\n", withdrawAmount);
            }
        } else {
            System.out.println("0원을 초과하는 금액을 출금해야합니다.");

        }

    }
}
