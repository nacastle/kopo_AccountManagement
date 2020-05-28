package IntegratedAccount.UI.Account;

import IntegratedAccount.UI.zExtra.ExitUI;
import IntegratedAccount.VO.AccountVO;
import IntegratedAccount.Service.Account.AccountService;
import IntegratedAccount.VO.UserVO;

import java.util.Random;
import java.util.Scanner;

public class CreateNewAccountUI extends BaseAccountUI {
    //Todo list: 통합계좌시스템에 새로운 계좌 생성

    Scanner sc = new Scanner(System.in);
    Random r = new Random();


    public void accountExecute(UserVO userVO) throws Exception {

        AccountService accountService = new AccountService();
        AccountVO accountVO = null;
        int accountNumber = 0;
        long tempBalance = 0;
        String accountOwner = null;
        String id = userVO.getId();


        System.out.println(">[캐슬은행]에서 새롭게 생성된 계좌의 계좌번호는 다음과 같습니다. "); // 계좌 생성시 계좌번호는 은행이 만들어주므로

        while (true) {
            accountNumber = r.nextInt(1000000) + 7000000;

            AccountVO tempAccountVO = accountService.selectAccountByAccountNumber(userVO, accountNumber);

            if ( tempAccountVO != null) {
            } else {
                System.out.println(accountNumber);
                break;
            }
        }
        System.out.print(">등록할 계좌의 별칭을 입력하세요 : ");
        String nickname = sc.nextLine();
//        System.out.print(">등록할 계좌의 계좌주명을 입력하세요 : ");
        accountOwner = accountService.selectAccount(id).getAccountOwner(); // 계좌주명 id로 조회해서 나옴

        System.out.println(">입금할 금액을 입력해주세요. 첫 계좌 생성 시, 최소 1000원 이상을 입금해야합니다.");
        tempBalance = sc.nextLong();
        sc.nextLine();
        if (tempBalance >= 1000) {
            accountVO = new AccountVO(id, nickname, accountNumber, "캐슬은행", accountOwner, tempBalance);
            accountService.registerAccount(userVO, accountVO);
            System.out.println("새로운 계좌가 등록되었습니다.");
        } else {
            System.out.println("계좌 생성을 위한 금액이 부족랍니다.(1000원 이상의 금액 필요)");
            new ExitUI().exitUI();
        }
    }

}

