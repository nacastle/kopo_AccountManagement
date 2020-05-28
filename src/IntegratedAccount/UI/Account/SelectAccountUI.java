package IntegratedAccount.UI.Account;

import IntegratedAccount.Service.Account.AccountService;
import IntegratedAccount.UI.zExtra.ExitUI;
import IntegratedAccount.UI.zExtra.WrongInput;
import IntegratedAccount.VO.AccountVO;
import IntegratedAccount.VO.UserVO;

import java.util.List;
import java.util.Scanner;

public class SelectAccountUI extends BaseAccountUI {

    //Todo list: 특정 계좌의 정보 조회(거래내역 포함)

    Scanner sc = new Scanner(System.in);


    public void accountExecute(UserVO userVO) throws Exception {

        AccountService accountService = new AccountService();
        AccountVO accountVO = null;
        List<AccountVO> accountVOList = null;

        loop1:
        while (true) {

            System.out.println("---------------------------------");
            System.out.println("\t조회 서비스 ");
            System.out.println("---------------------------------");
            System.out.println("\t1. 별칭으로 조회");
            System.out.println("\t2. 계좌번호로 조회");
            System.out.println("\t3. 은행명으로 조회");
            System.out.println("\t0. 종료");
            System.out.println("---------------------------------");
            System.out.print(">조회할 방법을 선택하세요 : ");

            String num = sc.nextLine();

            switch (num) {
                case "1":

                    System.out.print(">조회할 계좌의 별칭을 입력하세요 : ");
                    String tempNickname = sc.nextLine();

                    accountVOList = accountService.selectAccountByNickOrBank(userVO, tempNickname);

                    if (accountVOList == null) {
                        System.out.println("조회할 계좌가 없습니다.");
                        new ExitUI().exitUI();
                    } else {
                        AccountUI.showHead();
                        String id = null;
                        String nickname = null;
                        int accountNumber = 0;
                        String bank = null;
                        String accountOwner = null;
                        long balance = 0;
                        for (AccountVO tempAccountVO : accountVOList) {
                            id = tempAccountVO.getId();
                            nickname = tempAccountVO.getNickname();
                            accountNumber = tempAccountVO.getAccountNumber();
                            bank = tempAccountVO.getBank();
                            accountOwner = tempAccountVO.getAccountOwner();
                            balance = tempAccountVO.getBalance();

                            System.out.printf("%-10s %-15s %-15d %-10s %-10s %-20d\n", id, nickname, accountNumber, bank, accountOwner, balance);
                        }
                    }
                    break loop1;
                case "2":
                    System.out.print(">조회할 계좌번호를 입력하세요 : ");
                    int tempAccountNumber = sc.nextInt();
                    sc.nextLine();

                    accountVO = accountService.selectAccountByAccountNumber(userVO, tempAccountNumber);

                    if (accountVO == null) {
                        System.out.println("조회할 계좌가 없습니다.");
                        new ExitUI().exitUI();
                    } else {
                        AccountUI.showHead();
                        String id = accountVO.getId();
                        String nickname = accountVO.getNickname();
                        int accountNumber = accountVO.getAccountNumber();
                        String bank = accountVO.getBank();
                        String accountOwner = accountVO.getAccountOwner();
                        long balance = accountVO.getBalance();

                        System.out.printf("%-10s %-15s %-15d %-10s %-10s %-20d\n", id, nickname, accountNumber, bank, accountOwner, balance);

                    }
                    break loop1;

                case "3":
                    System.out.print(">조회할 은행을 입력하세요 : ");
                    String tempBank = sc.nextLine();

                    accountVOList = accountService.selectAccountByNickOrBank(userVO, tempBank);

                    if (accountVOList == null) {
                        System.out.println("조회할 계좌가 없습니다.");
                        new ExitUI().exitUI();
                    } else {
                        AccountUI.showHead();

                        for (AccountVO tempAccountVO : accountVOList) {
                            String id = tempAccountVO.getId();
                            String nickname = tempAccountVO.getNickname();
                            int accountNumber = tempAccountVO.getAccountNumber();
                            String bank = tempAccountVO.getBank();
                            String accountOwner = tempAccountVO.getAccountOwner();
                            long balance = tempAccountVO.getBalance();

                            System.out.printf("%-10s %-15s %-15d %-10s %-10s %-20d\n", id, nickname, accountNumber, bank, accountOwner, balance);
                        }
                    }
                    break loop1;

                case "0":
                    System.out.println("조회 서비스를 종료합니다.");
                    break loop1;

                default:
                    new WrongInput().wrongInput();
            }

        }
    }
}


