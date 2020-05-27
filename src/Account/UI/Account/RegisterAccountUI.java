package Account.UI.Account;

import Account.Service.AccountService;
import Account.UI.ExitUI;
import Account.UI.WrongInput;
import Account.VO.AccountVO;
import Account.VO.UserVO;

import java.util.Random;
import java.util.Scanner;

public class RegisterAccountUI extends BaseAccountUI {
    //Todo list: 타행의 기존 계좌 등록

    Scanner sc = new Scanner(System.in);

    public void accountExecute(UserVO userVO) throws Exception {

        AccountService accountService = new AccountService();
        AccountVO accountVO = null;

        String bank = null;
        loop1:
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("\t계좌 등록 서비스 ");
            System.out.println("---------------------------------");
            System.out.println("\t1. 하나은행\n" +
                    "\t2. 우리은행\n" +
                    "\t3. 국민은행\n" +
                    "\t4. 신한은행\n" +
                    "\t5. 기업은행\n" +
                    "\t6. 농협은행\n" +
                    "\t7. 수협은행\n" +
                    "\t8. 카카오뱅크\n" +
                    "\t9. 케이뱅크");
            System.out.println("---------------------------------");
            System.out.print(">등록할 계좌번호의 은행을 고르세요 : ");
            String bankNum = sc.nextLine();

            switch (bankNum) {
                case "1":
                    bank = "하나은행";
                    break loop1;
                case "2":
                    bank = "우리은행";
                    break loop1;
                case "3":
                    bank = "국민은행";
                    break loop1;
                case "4":
                    bank = "신한은행";
                    break loop1;
                case "5":
                    bank = "기업은행";
                    break loop1;
                default:
                    new WrongInput().wrongInput();
            }
        }

        System.out.print(">등록할 계좌번호를 입력하세요 : ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        if (accountService.selectAccountByAccountNumber(userVO, accountNumber) != null) {
            System.out.println("이미 등록된 계좌입니다.");
            new ExitUI().exitUI();
        } else {
            System.out.print(">등록할 계좌의 별칭을 입력하세요 : ");

            String nickname = sc.nextLine();
            String accountOwner = userVO.getName(); // 계좌주명 id로 select해서 가져오기
            Random r = new Random();
            int balance = (r.nextInt(100) + 1) * 1000; // 잔액은 설정해주는 것이 아닌 이미 정해져있는 것이기에 랜덤으로 처리(1000원 이상)
            accountVO = new AccountVO(userVO.getId(), nickname, accountNumber, bank, accountOwner, balance);

            accountService.registerAccount(userVO, accountVO);
            System.out.println("새로운 계좌가 등록되었습니다.");
        }
    }
}
