package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import Account.AccountVO.AccountVO;
import User.UserVO.UserVO;

import java.util.Random;
import java.util.Scanner;

public class RegisterAccountUI {
    //Todo list: 타행의 기존 계좌 등록

    Scanner sc = new Scanner(System.in);

    public void registerAccountUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();
        AccountVO accountVO = null;


        System.out.print(">등록할 계좌번호를 입력하세요 : ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        if (accountDAO.selectAccountDAO(userVO, accountNumber) != null) {
            System.out.println("이미 등록된 계좌입니다.");
            new ExitUI().exitUI();
            System.exit(0);
        } else {
            System.out.print(">등록할 계좌의 별칭을 입력하세요 : ");
            String nickname = sc.nextLine();
            System.out.print(">등록할 계좌의 은행명을 입력하세요 : ");
            String bank = sc.nextLine();
            System.out.print(">등록할 계좌의 계좌주명을 입력하세요 : ");
            String accountOwner = sc.nextLine();
            Random r = new Random();
            int balance = (r.nextInt(100) + 1) * 1000; // 잔액은 설정해주는 것이 아닌 이미 정해져있는 것이기에 랜덤으로 처리(1000원 이상)
            accountVO = new AccountVO(userVO.getId(),nickname,accountNumber,bank,accountOwner,balance);

            accountDAO.registerAccountDAO(userVO, accountVO);
            System.out.println("새로운 계좌가 등록되었습니다.");
        }

    }
}
