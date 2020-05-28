package IntegratedAccount.UI.Account;

import IntegratedAccount.UI.zExtra.ExitUI;
import IntegratedAccount.UI.zExtra.WrongInput;
import IntegratedAccount.VO.UserVO;

import java.util.Scanner;

public class AccountUI  extends BaseAccountUI{

    Scanner sc = new Scanner(System.in);


    public String chooseMenu() {
        System.out.println("---------------------------------");
        System.out.println("[캐슬은행] 통합계좌 관리 프로그램(DB)");
        System.out.println("---------------------------------");
        System.out.println("\t1. 전체 계좌 조회");
        System.out.println("\t2. 특정 계좌 조회");
        System.out.println("\t3. 입출금 및 이체");
        System.out.println("\t4. 새로운 계좌 등록");
        System.out.println("\t5. 새로운 계좌 생성");
        System.out.println("\t6. 계좌 별칭 수정");
        System.out.println("\t7. 특정 계좌 삭제");
        System.out.println("\t0. 종료");
        System.out.println("---------------------------------");

        System.out.print(">사용하실 항목 번호를 선택하세요 : ");
        String num = sc.nextLine();


        return num;
    }

    public String chooseSubMenu() {
        System.out.println("---------------------------------");
        System.out.println("\t입출금 및 이체 서비스");
        System.out.println("---------------------------------");
        System.out.println("\t1. 입금");
        System.out.println("\t2. 출금");
        System.out.println("\t3. 이체");
        System.out.println("\t0. 종료");
        System.out.println("---------------------------------");
        System.out.print(">사용하실 항목 번호를 선택하세요 : ");
        String num = sc.nextLine();


        return num;
    }

    public int chooseSubMenu2() {
        System.out.println("---------------------------------");
        System.out.println("\t이체 서비스");
        System.out.println("---------------------------------");
        System.out.println("\t1. 셀프 이체");
        System.out.println("\t2. 출금");
        System.out.println("\t3. 이체");
        System.out.println("\t0. 종료");
        System.out.println("---------------------------------");
        System.out.print(">사용하실 항목 번호를 선택하세요 : ");
        int num = sc.nextInt();
        sc.nextLine();

        return num;
    }

    public static void showHead() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-14s %-13s %-10s %-10s %-20s\n", "ID", "계좌 별칭", "계좌번호", "은행", "계좌주명", "잔금");
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void accountExecute (UserVO userVO) throws Exception {


        while (true) {
            IAccountUI ui = null;
            switch (chooseMenu()) {
                case "1":
                    ui = new SelectAllAccountUI();
                    break;

                case "2":
                    ui = new SelectAccountUI();
                    break;

                case "3":
                    ui = new GeneralBankingUI();
                    break;

                case "4":
                    ui = new RegisterAccountUI();
                    break;

                case "5":
                    ui = new CreateNewAccountUI();
                    break;

                case "6":
                    ui = new ReviseAccountUI();
                    break;

                case "7":
                    ui = new DeleteAccountUI();
                    break;

                case "0":
                    new ExitUI().exitUI();
                    System.exit(0);
                    break;

                default:
                    new WrongInput().wrongInput();

            }
            if (ui != null) {
                ui.accountExecute(userVO);
            }
        }
    }
}


