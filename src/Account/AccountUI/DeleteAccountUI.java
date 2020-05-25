package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import User.UserVO.UserVO;

import java.util.Scanner;

public class DeleteAccountUI {
    //Todo list: 특정 계좌 삭제

    Scanner sc = new Scanner(System.in);

    public void deleteAccountUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();

        System.out.print(">삭제할 계좌의 별칭을 입력하세요 : ");
        String tempNickname = sc.nextLine();

        if (accountDAO.selectAccountDAO(userVO, tempNickname) == null) {
            System.out.println("조회되는 계좌가 없습니다.");
            new ExitUI().exitUI();
        } else {
            accountDAO.deleteAccountDAO(userVO, tempNickname);
            System.out.printf("'%s' 계좌가 삭제되었습니다.", tempNickname);
        }

    }

}
