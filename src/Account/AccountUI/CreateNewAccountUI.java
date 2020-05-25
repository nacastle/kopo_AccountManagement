package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import Account.AccountVO.AccountVO;
import User.UserVO.UserVO;

import java.util.Random;
import java.util.Scanner;

public class CreateNewAccountUI {
    //To do list: 통합계좌시스템에 새로운 계좌 생성

    Scanner sc = new Scanner(System.in);
    Random r = new Random();


    public void createNewAccountUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();
        AccountVO accountVO = null;
        int accountNumber = 0;
        long tempBalance = 0;


        System.out.println(">[캐슬은행]에서 새롭게 생성된 계좌의 계좌번호는 다음과 같습니다. "); // 계좌 생성시 계좌번호는 은행이 만들어주므로

        while (true) {
            accountNumber = r.nextInt(1000000) + 7000000;
            if (accountDAO.selectAccountDAO(userVO, accountNumber) != null) {
            } else {
                System.out.println(accountNumber);
                break;
            }
        }
        System.out.print(">등록할 계좌의 별칭을 입력하세요 : ");
        String nickname = sc.nextLine();
//        System.out.print(">등록할 계좌의 계좌주명을 입력하세요 : ");
        String accountOwner = accountDAO.selectAccountDAO(userVO.getId()).getAccountOwner(); // 계좌주명 id로 조회해서 나옴

        System.out.println(">입금할 금액을 입력해주세요. 첫 계좌 생성 시, 최소 1000원 이상을 입금해야합니다.");
        tempBalance = sc.nextLong();
        sc.nextLine();
        if (tempBalance >= 1000) {
            accountVO = new AccountVO(userVO.getId(), nickname, accountNumber, "캐슬은행", accountOwner, tempBalance);
            accountDAO.registerAccountDAO(userVO, accountVO);
            System.out.println("새로운 계좌가 등록되었습니다.");
        } else {
            System.out.println("계좌 생성을 위한 금액이 모자랍니다.(1000원 미만)");
            new ExitUI().exitUI();
        }
    }

}

