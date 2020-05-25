package Account.AccountUI;

import Account.AccountDAO.AccountDAO;
import Account.AccountVO.AccountVO;
import User.UserVO.UserVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RegisterAccountUI {
    //Todo list: 타행의 기존 계좌 등록

    Scanner sc = new Scanner(System.in);

    public void registerAccountUI(UserVO userVO) {

        AccountDAO accountDAO = new AccountDAO();
        AccountVO accountVO = null;

        // 등록 가능한  은행 리스트
        List<String> bankList = new ArrayList<>(); // 대상 은행이 더 늘어날 경우를 대비해 ArrayList 로 구현
        bankList.add("하나은행");
        bankList.add("우리은행");
        bankList.add("국민은행");
        bankList.add("신한은행");
        bankList.add("기업은행");
        bankList.add("농협은행");
        bankList.add("수협은행");
        bankList.add("카카오뱅크");
        bankList.add("케이뱅크");

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

        int num = sc.nextInt();
        sc.nextLine();
        if (num < 1 || num > 9) {
            new ExitUI().exitUI();
        }
        String bank = bankList.get(num - 1);

        System.out.print(">등록할 계좌번호를 입력하세요 : ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        if (accountDAO.selectAccountDAO(userVO, accountNumber) != null) {
            System.out.println("이미 등록된 계좌입니다.");
            new ExitUI().exitUI();
        } else {
            System.out.print(">등록할 계좌의 별칭을 입력하세요 : ");
            String nickname = sc.nextLine();
            System.out.print(">등록할 계좌의 계좌주명을 입력하세요 : ");
            String accountOwner = sc.nextLine();
            Random r = new Random();
            int balance = (r.nextInt(100) + 1) * 1000; // 잔액은 설정해주는 것이 아닌 이미 정해져있는 것이기에 랜덤으로 처리(1000원 이상)
            accountVO = new AccountVO(userVO.getId(), nickname, accountNumber, bank, accountOwner, balance);

            accountDAO.registerAccountDAO(userVO, accountVO);
            System.out.println("새로운 계좌가 등록되었습니다.");
        }

    }
}
