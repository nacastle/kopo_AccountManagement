package IntegratedAccount.UI.Account;

import IntegratedAccount.Service.Account.AccountService;
import IntegratedAccount.UI.zExtra.ExitUI;
import IntegratedAccount.VO.AccountVO;
import IntegratedAccount.VO.UserVO;

import java.util.Scanner;

public class ReviseAccountUI extends BaseAccountUI {
    //Todo list: 계좌 별칭 수정

    Scanner sc = new Scanner(System.in);

    public void accountExecute(UserVO userVO) throws Exception {

        AccountService accountService = new AccountService();

        String originalNickname = null;
        System.out.print(">변경할 계좌의 계좌번호를 입력하세요 : ");
        int tempAccountNumber = sc.nextInt();
        sc.nextLine();
        System.out.print(">새로운 별칭을 입력하세요 : ");
        String newNickname = sc.nextLine();

        AccountVO accountVO = accountService.selectAccountByAccountNumber(userVO, tempAccountNumber);

        if (accountVO == null) {
            System.out.println("조회되는 계좌가 없습니다.");
            new ExitUI().exitUI();
        } else {
            originalNickname = accountService.selectAccount(tempAccountNumber).getNickname();
            accountService.reviseAccount(userVO, newNickname, tempAccountNumber);

            System.out.printf("'%s'에서 '%s'(으)로 별칭이 변경되었습니다.\n", originalNickname, newNickname);
        }


    }

}
