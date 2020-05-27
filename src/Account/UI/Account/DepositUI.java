package Account.UI.Account;

import Account.Service.AccountService;
import Account.VO.AccountVO;
import Account.VO.UserVO;

import java.util.Scanner;

public class DepositUI extends BaseAccountUI {
    //Todo List 입금 기능 구현

    Scanner sc = new Scanner(System.in);

    public void accountExecute(UserVO userVO) throws Exception {

        AccountService accountService = new AccountService();

        System.out.println("---------------------------------");
        System.out.println("\t입금 서비스 ");
        System.out.println("---------------------------------");

        int tempAccountNumber = 0;
        long originalBalance = 0; // 기존 잔액 구하기
        long depositAmount = 0;
        AccountVO accountVO = null;

        System.out.print(">입금할 계좌번호를 입력하세요 : ");
        tempAccountNumber = sc.nextInt();
        sc.nextLine();
        accountVO = accountService.selectAccountByAccountNumber(userVO, tempAccountNumber);

        if (accountVO == null) {
            System.out.println("조회되는 계좌가 없습니다.");
            System.out.println("입금 서비스를 종료합니다.");
        } else {
            System.out.print(">입금할 금액을 입력하세요 : ");
            depositAmount = sc.nextLong();
            sc.nextLine();
            originalBalance = accountVO.getBalance();
            accountService.deposit(userVO, originalBalance, depositAmount, tempAccountNumber);
            System.out.printf("%d원이 입금되었습니다.\n", depositAmount);
        }



    }
}