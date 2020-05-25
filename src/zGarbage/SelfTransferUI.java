package zGarbage;

import Account.AccountDAO.AccountDAO;
import Account.AccountUI.ExitUI;
import User.UserVO.UserVO;

import java.util.Scanner;

public class SelfTransferUI {
    //Todo List : 돈을 다른 내 계좌로 이체하는 기능 (잔금을 넘어서는 금액이면 이체 불가)
    Scanner sc = new Scanner(System.in);

    public void selfTransferUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();
        System.out.println("---------------------------------");
        System.out.println("\t내 계좌로 이체 서비스 ");
        System.out.println("---------------------------------");
        System.out.println("\t1. 별칭으로 이체");
        System.out.println("\t2. 계좌번호로 이체");
        System.out.println("---------------------------------");
        System.out.print(">이체할 방법을 선택하세요 : ");
        int num = sc.nextInt();
        sc.nextLine();

        String sendNickname = null; // 돈을 보내는 계좌
        String receiveNickname = null; // 돈을 받는 계좌
        int sendAccountNumber = 0; // 돈을 보내는 계좌
        int receiveAccountNumber = 0; // 돈을 받는 계좌
        long sendBalance = 0; // 보내는 계좌의 기존 잔액 구하기
        long receiveBalance = 0; // 보내는 계좌의 기존 잔액 구하기
        long sendAmount = 0; // 이체할 금액


        switch (num) {
            case 1:
                System.out.print(">계좌의 별칭을 입력하세요 : ");
                sendNickname = sc.nextLine();
                if (accountDAO.selectAccountDAO(userVO, sendNickname) == null) {
                    System.out.println("조회되는 계좌가 없습니다.");
                    new ExitUI().exitUI();
                    System.exit(0);
                } else {
                    System.out.print(">이체할 계좌의 별칭을 입력해주세요 : ");
                    receiveNickname = sc.nextLine();

                    System.out.print(">이체할 금액을 입력하세요 : ");
                    sendAmount = sc.nextLong();
                    sc.nextLine();

                    sendBalance = new AccountDAO().selectAccountDAO(userVO, sendNickname).getBalance();
                    receiveBalance = new AccountDAO().selectAccountDAO(userVO,receiveNickname).getBalance();

                    if (sendBalance < sendAmount) {
                        System.out.println("잔금을 초과합니다.");
                        new ExitUI().exitUI();
                        System.exit(0);
                    } else {
                        accountDAO.withdrawDAO(userVO, sendBalance, sendAmount, sendNickname, sendAccountNumber);
                        accountDAO.depositDAO(userVO,receiveBalance,sendAmount,receiveNickname,receiveAccountNumber);
                        System.out.printf("%d원이 이체되었습니다.\n",sendAmount);
                    }
                }
                break;

            case 2:
                System.out.print(">계좌번호를 입력하세요 : ");
                sendAccountNumber = sc.nextInt();
                sc.nextLine();
                if (accountDAO.selectAccountDAO(userVO, sendAccountNumber) == null) {
                    System.out.println("조회되는 계좌가 없습니다.");
                    new ExitUI().exitUI();
                    System.exit(0);
                } else {
                    System.out.print(">이체할 계좌번호를 입력해주세요 : ");
                    receiveAccountNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print(">이체할 금액을 입력하세요 : ");
                    sendAmount = sc.nextLong();
                    sc.nextLine();

                    sendBalance = new AccountDAO().selectAccountDAO(userVO, sendAccountNumber).getBalance();
                    receiveBalance = new AccountDAO().selectAccountDAO(userVO,receiveAccountNumber).getBalance();

                    if (sendBalance < sendAmount) {
                        System.out.println("잔금을 초과합니다.");
                        new ExitUI().exitUI();
                        System.exit(0);
                    } else {
                        accountDAO.withdrawDAO(userVO, sendBalance, sendAmount, sendNickname, sendAccountNumber);
                        accountDAO.depositDAO(userVO,receiveBalance,sendAmount,receiveNickname,receiveAccountNumber);
                        System.out.printf("%d원이 이체되었습니다.\n",sendAmount);
                    }
                }
                break;

            default:
                System.out.println("잘못된 입력입니다.");
                new ExitUI().exitUI();
                System.exit(0);
                break;
        }

    }
}
