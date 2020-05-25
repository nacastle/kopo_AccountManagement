package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import User.UserVO.UserVO;

import java.util.Scanner;

public class TransferUI {
    //Todo List: 다른 사람에게 돈을 이체하는 서비스 구현

    Scanner sc = new Scanner(System.in);

    public void transferUI(UserVO myUserVO) {

        AccountDAO accountDAO = new AccountDAO();
        System.out.println("---------------------------------");
        System.out.println("\t계좌이체 서비스 ");
        System.out.println("---------------------------------");
        System.out.println("\t1. 별칭으로 이체");
        System.out.println("\t2. 계좌번호로 이체");
        System.out.println("---------------------------------");
        System.out.print(">이체할 방법을 선택하세요 : ");
        int num = sc.nextInt();
        sc.nextLine();

        String sendNickname = null; // 돈을 보내는 계좌 별칭
        String receiveNickname = null; // 돈을 받을 계좌 별칭
        int sendAccountNumber = 0; // 돈을 보내는 계좌 계좌번호
        int receiveAccountNumber = 0; // 돈을 받는 계좌 계좌번호
        String receiveId = null;
        long sendBalance = 0; // 보내는 계좌의 기존 잔액 구하기
        long receiveBalance = 0; // 보내는 계좌의 기존 잔액 구하기
        long sendAmount = 0; // 이체할 금액
//        UserVO othersUserVO = null; // 돈을 받을 유저의 id 정보를 담을 객체


        switch (num) {
            case 1:
                System.out.print(">계좌의 별칭을 입력하세요 : ");
                sendNickname = sc.nextLine();
                if (accountDAO.selectAccountDAO(myUserVO, sendNickname) == null) {
                    System.out.println("조회되는 계좌가 없습니다.");
                    new ExitUI().exitUI();
                } else {
                    System.out.print(">이체할 계좌번호를 입력해주세요 : ");
                    receiveAccountNumber = sc.nextInt();
                    sc.nextLine();

                    receiveId = accountDAO.selectAccountDAO(receiveAccountNumber).getId();
                    if (receiveId == null) {
                        System.out.println("조회되는 계좌가 없습니다.");
                        new ExitUI().exitUI();
                    } else {
                        UserVO receiveUserVO = new UserVO(); // 돈을 받을 유저의 id 정보를 담을 객체
                        receiveUserVO.setId(receiveId);

                        System.out.print(">이체할 금액을 입력하세요 : ");
                        sendAmount = sc.nextLong();
                        sc.nextLine();

                        sendBalance = new AccountDAO().selectAccountDAO(myUserVO, sendNickname).getBalance();
                        receiveBalance = new AccountDAO().selectAccountDAO(receiveUserVO, receiveAccountNumber).getBalance();

                        if (sendBalance < sendAmount) {
                            System.out.println("잔금을 초과합니다.");
                            new ExitUI().exitUI();
                        } else {
                            accountDAO.withdrawDAO(myUserVO, sendBalance, sendAmount, sendNickname, sendAccountNumber);
                            accountDAO.depositDAO(receiveUserVO, receiveBalance, sendAmount, receiveNickname, receiveAccountNumber);
                            System.out.printf("%d원이 이체되었습니다.\n", sendAmount);
                        }
                    }
                }
                break;

            case 2:
                System.out.print(">계좌번호를 입력하세요 : ");
                sendAccountNumber = sc.nextInt();
                sc.nextLine();
                if (accountDAO.selectAccountDAO(myUserVO, sendAccountNumber) == null) {
                    System.out.println("조회되는 계좌가 없습니다.");
                    new ExitUI().exitUI();
                } else {
                    System.out.print(">이체할 계좌번호를 입력해주세요 : ");
                    receiveAccountNumber = sc.nextInt();
                    sc.nextLine();

                    receiveId = accountDAO.selectAccountDAO(receiveAccountNumber).getId();
                    if (receiveId == null) {
                        System.out.println("조회되는 계좌가 없습니다.");
                        new ExitUI().exitUI();
                    } else {
                        UserVO receiveUserVO = new UserVO(); // 돈을 받을 유저의 id 정보를 담을 객체
                        receiveUserVO.setId(receiveId);

                        System.out.print(">이체할 금액을 입력하세요 : ");
                        sendAmount = sc.nextLong();
                        sc.nextLine();

                        sendBalance = new AccountDAO().selectAccountDAO(myUserVO, sendAccountNumber).getBalance();
                        receiveBalance = new AccountDAO().selectAccountDAO(receiveUserVO, receiveAccountNumber).getBalance();

                        if (sendBalance < sendAmount) {
                            System.out.println("잔금을 초과합니다.");
                            new ExitUI().exitUI();
                        } else {
                            accountDAO.withdrawDAO(myUserVO, sendBalance, sendAmount, sendNickname, sendAccountNumber);
                            accountDAO.depositDAO(receiveUserVO, receiveBalance, sendAmount, receiveNickname, receiveAccountNumber);
                            System.out.printf("%d원이 이체되었습니다.\n", sendAmount);
                        }
                    }
                }
                break;

            default:
                System.out.println("잘못된 입력입니다.");
                new ExitUI().exitUI();
                break;
        }

    }
}
