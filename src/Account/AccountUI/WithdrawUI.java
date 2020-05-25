package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import User.UserVO.UserVO;

import java.util.Scanner;

public class WithdrawUI {
    //Todo list: 출금 기능 (뭘 받아서 DAO에 어떤 메소드를 쓸거임)

    Scanner sc = new Scanner(System.in);

    public void withdrawUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();
        System.out.println("---------------------------------");
        System.out.println("\t출금 서비스 ");
        System.out.println("---------------------------------");
        System.out.println("\t1. 별칭으로 출금");
        System.out.println("\t2. 계좌번호로 출금");
        System.out.println("---------------------------------");
        System.out.print(">출금할 방법을 선택하세요 : ");
        int num = sc.nextInt();
        sc.nextLine();


        String tempNickname = null;
        int tempAccountNumber = 0;
        long originalBalance = 0;
        long withdrawAmount = 0;

        switch (num) {
            case 1:
                System.out.print(">출금할 계좌의 별칭을 입력하세요 : ");
                tempNickname = sc.nextLine();
                if (accountDAO.selectAccountDAO(userVO, tempNickname) == null) {
                    System.out.println("조회되는 계좌가 없습니다.");
                    new ExitUI().exitUI();
                } else {
                    System.out.print(">출금할 금액을 입력하세요 : ");
                    withdrawAmount = sc.nextLong();
                    sc.nextLine();
                }
                break;

            case 2:
                System.out.print(">출금할 계좌번호를 입력하세요 : ");
                tempAccountNumber = sc.nextInt();
                sc.nextLine();
                if (accountDAO.selectAccountDAO(userVO, tempAccountNumber) == null) {
                    System.out.println("조회되는 계좌가 없습니다.");
                    new ExitUI().exitUI();
                } else {
                    System.out.print(">출금할 금액을 입력하세요 : ");
                    withdrawAmount = sc.nextLong();
                    sc.nextLine();
                    originalBalance = new AccountDAO().selectAccountDAO(userVO, tempNickname).getBalance();
                }
                break;

            default:
                System.out.println("잘못된 입력입니다.");
                new ExitUI().exitUI();
                break;
        }

        if (tempNickname != null) {
            originalBalance = new AccountDAO().selectAccountDAO(userVO, tempNickname).getBalance();
        } else if (tempAccountNumber != 0) {
            originalBalance = new AccountDAO().selectAccountDAO(userVO, tempAccountNumber).getBalance();
        }

        if (originalBalance < withdrawAmount) {
            System.out.println("잔금을 초과합니다.");
            new ExitUI().exitUI();
        } else {
            accountDAO.withdrawDAO(userVO, originalBalance, withdrawAmount, tempNickname, tempAccountNumber);
            System.out.printf("%d원이 출금되었습니다.\n", withdrawAmount);
        }

    }
}
