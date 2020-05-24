package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import User.UserVO.UserVO;

import java.util.Scanner;

public class DepositUI {
    //Todo List 입금 기능 구현

    Scanner sc = new Scanner(System.in);

    public void depositUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();
        System.out.println("---------------------------------");
        System.out.println("\t입금 서비스 ");
        System.out.println("---------------------------------");
        System.out.println("\t1. 별칭으로 입금");
        System.out.println("\t2. 계좌번호로 입금");
        System.out.println("---------------------------------");
        System.out.print(">입금할 방법을 선택하세요 : ");
        int num = sc.nextInt();
        sc.nextLine();


        String tempNickname = null;
        int tempAccountNumber = 0;
        long originalBalance = 0; // 기존 잔액 구하기
        long depositAmount = 0;

        switch (num) {
            case 1:
                System.out.print(">입금할 계좌의 별칭을 입력하세요 : ");
                tempNickname = sc.nextLine();
                if (accountDAO.selectAccountDAO(userVO, tempNickname) == null) {
                    System.out.println("조회되는 계좌가 없습니다.");
                    new ExitUI().exitUI();
                    System.exit(0);
                } else {
                    System.out.print(">입금할 금액을 입력하세요 : ");
                    depositAmount = sc.nextLong();
                    sc.nextLine();
                }
                break;

            case 2:
                System.out.print(">입금할 계좌번호를 입력하세요 : ");
                tempAccountNumber = sc.nextInt();
                sc.nextLine();
                if (accountDAO.selectAccountDAO(userVO, tempAccountNumber) == null) {
                    System.out.println("조회되는 계좌가 없습니다.");
                    new ExitUI().exitUI();
                    System.exit(0);
                } else {
                    System.out.print(">입금할 금액을 입력하세요 : ");
                    depositAmount = sc.nextLong();
                    sc.nextLine();
                    originalBalance = new AccountDAO().selectAccountDAO(userVO, tempNickname).getBalance();
                }
                break;

            default:
                System.out.println("잘못된 입력입니다.");
                new ExitUI().exitUI();
                System.exit(0);
                break;
        }

        if (tempNickname!=null) {
            originalBalance = new AccountDAO().selectAccountDAO(userVO, tempNickname).getBalance();
        } else if (tempAccountNumber != 0) {
            originalBalance = new AccountDAO().selectAccountDAO(userVO, tempAccountNumber).getBalance();
        }

        accountDAO.depositDAO(userVO, originalBalance, depositAmount, tempNickname, tempAccountNumber);
        System.out.printf("%d원이 입금되었습니다.\n",depositAmount);

    }
}