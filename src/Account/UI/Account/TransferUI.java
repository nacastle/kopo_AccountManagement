package Account.UI.Account;

import Account.Service.AccountService;
import Account.UI.ExitUI;
import Account.VO.AccountVO;
import Account.VO.UserVO;

import java.util.Scanner;

public class TransferUI extends BaseAccountUI {
    //Todo List: 다른 사람에게 돈을 이체하는 서비스 구현

    Scanner sc = new Scanner(System.in);

    public void accountExecute(UserVO myUserVO) throws Exception {

        AccountService accountService = new AccountService();

        System.out.println("---------------------------------");
        System.out.println("\t계좌이체 서비스 ");
        System.out.println("---------------------------------");

        int sendAccountNumber = 0; // 돈을 보내는 계좌 계좌번호
        int receiveAccountNumber = 0; // 돈을 받는 계좌 계좌번호
        String receiveId = null;
        String receiveAccountOwner = null;
        long sendBalance = 0; // 보내는 계좌의 기존 잔액 구하기
        long receiveBalance = 0; // 보내는 계좌의 기존 잔액 구하기
        long sendAmount = 0; // 이체할 금액
        AccountVO myAccountVO = null;

        System.out.print(">출금하는 계좌의 계좌번호를 입력하세요 : ");
        sendAccountNumber = sc.nextInt();
        sc.nextLine();
        myAccountVO = accountService.selectAccountByAccountNumber(myUserVO, sendAccountNumber);
        if (myAccountVO == null) {
            System.out.println("조회되는 계좌가 없습니다.");
            System.out.println("이체 서비스를 종료합니다.");
        } else {
            System.out.print(">이체할 계좌번호를 입력해주세요 : ");
            receiveAccountNumber = sc.nextInt();
            sc.nextLine();

            receiveId = accountService.selectAccount(receiveAccountNumber).getId();
            if (receiveId == null) {
                System.out.println("조회되는 계좌가 없습니다.");
                new ExitUI().exitUI();
            } else {
                UserVO receiveUserVO = new UserVO(); // 돈을 받을 유저의 id 정보를 담을 객체
                receiveUserVO.setId(receiveId);

                System.out.print(">이체할 금액을 입력하세요 : ");
                sendAmount = sc.nextLong();
                sc.nextLine();
                if (sendAmount > 0) {

                    sendBalance = myAccountVO.getBalance();
                    receiveBalance = accountService.selectAccount(receiveAccountNumber).getBalance();
                    receiveAccountOwner = accountService.selectAccount(receiveAccountNumber).getAccountOwner();

                    if (sendBalance < sendAmount) {
                        System.out.println("잔액을 초과하는 금액을 입력했습니다.");
                        new ExitUI().exitUI();
                    } else {
                        accountService.withdraw(myUserVO, sendBalance, sendAmount, sendAccountNumber);
                        accountService.deposit(receiveUserVO, receiveBalance, sendAmount, receiveAccountNumber);

                        System.out.printf("%s 님에게 %d원을 이체했습니다.\n", receiveAccountOwner, sendAmount);
                    }
                } else {
                    System.out.println("0원을 초과하는 금액을 이체해야합니다.");

                }
            }
        }
    }

}

