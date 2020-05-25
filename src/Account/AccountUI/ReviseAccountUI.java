package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import User.UserVO.UserVO;

import java.util.Scanner;

public class ReviseAccountUI {
    //Todo list: 계좌 별칭 수정

    Scanner sc = new Scanner(System.in);

    public void reviseAccountUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();

        System.out.print(">변경할 계좌의 별칭을 입력하세요 : ");
        String tempNickname = sc.nextLine();
        System.out.print(">새로운 별칭을 입력하세요 : ");
        String newNickname = sc.nextLine();

        if (accountDAO.selectAccountDAO(userVO, tempNickname) == null) {
            System.out.println("조회되는 계좌가 없습니다.");
            new ExitUI().exitUI();
        } else {
            accountDAO.reviseAccountDAO(userVO, newNickname, tempNickname);
            System.out.printf("'%s'에서 '%s'(으)로 별칭이 변경되었습니다.\n", tempNickname, newNickname);
        }


    }

}
