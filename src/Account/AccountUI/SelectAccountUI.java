package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import User.UserVO.UserVO;

import java.util.Scanner;

public class SelectAccountUI {

    //Todo list: 특정 계좌의 정보 조회(거래내역 포함)

    Scanner sc = new Scanner(System.in);


    public void selectAcountUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();

        System.out.println("---------------------------------");
        System.out.println("\t조회 서비스 ");
        System.out.println("---------------------------------");
        System.out.println("\t1. 별칭으로 조회");
        System.out.println("\t2. 계좌번호로 조회");
        System.out.println("---------------------------------");
        System.out.print(">조회할 방법을 선택하세요 : ");

        int num = sc.nextInt();
        sc.nextLine();

        if (num == 1) {
            System.out.print(">조회할 계좌의 별칭을 입력하세요 : ");
            String tempNickname = sc.nextLine();

            if (accountDAO.selectAccountDAO(userVO, tempNickname) == null) {
                System.out.println("조회할 계좌가 없습니다.");
                new ExitUI().exitUI();
                System.exit(0);
            } else {
                AccountUI accountUI = new AccountUI();
                accountUI.showHead();
                String id = accountDAO.selectAccountDAO(userVO, tempNickname).getId();
                String nickname = accountDAO.selectAccountDAO(userVO, tempNickname).getNickname();
                int accountNumber = accountDAO.selectAccountDAO(userVO, tempNickname).getAccountNumber();
                String bank = accountDAO.selectAccountDAO(userVO, tempNickname).getBank();
                String accountOwner = accountDAO.selectAccountDAO(userVO, tempNickname).getAccountOwner();
                long balance = accountDAO.selectAccountDAO(userVO, tempNickname).getBalance();

                System.out.printf("%-10s %-15s %-15d %-10s %-10s %-20d\n", id, nickname, accountNumber, bank, accountOwner, balance);
            }

        } else if (num == 2) {
            System.out.print(">조회할 계좌번호를 입력하세요 : ");
            int tempAccountNumber = sc.nextInt();
            sc.nextLine();

            if (accountDAO.selectAccountDAO(userVO, tempAccountNumber) == null) {
                System.out.println("조회할 계좌가 없습니다.");
                new ExitUI().exitUI();
                System.exit(0);
            } else {
                AccountUI accountUI = new AccountUI();
                accountUI.showHead();
                String id = accountDAO.selectAccountDAO(userVO, tempAccountNumber).getId();
                String nickname = accountDAO.selectAccountDAO(userVO, tempAccountNumber).getNickname();
                int accountNumber = accountDAO.selectAccountDAO(userVO, tempAccountNumber).getAccountNumber();
                String bank = accountDAO.selectAccountDAO(userVO, tempAccountNumber).getBank();
                String accountOwner = accountDAO.selectAccountDAO(userVO, tempAccountNumber).getAccountOwner();
                long balance = accountDAO.selectAccountDAO(userVO, tempAccountNumber).getBalance();

                System.out.printf("%-10s %-15s %-15d %-10s %-10s %-20d\n", id, nickname, accountNumber, bank, accountOwner, balance);

            }
        } else {
            new WrongInput().wrongInput();
            System.exit(0);
        }
    }
}


