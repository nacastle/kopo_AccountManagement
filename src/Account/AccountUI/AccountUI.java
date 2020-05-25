package Account.AccountUI;

import User.UserUI.LoginUI;
import User.UserUI.UserUI;
import User.UserVO.UserVO;

import java.util.Scanner;

public class AccountUI {

    Scanner sc = new Scanner(System.in);


    public int chooseMenu() {
        System.out.println("---------------------------------");
        System.out.println("\t통합계좌 관리 프로그램(DB)");
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
        int num = sc.nextInt();

        return num;
    }

    public int chooseSubMenu() {
        System.out.println("---------------------------------");
        System.out.println("\t입출금 및 이체 서비스");
        System.out.println("---------------------------------");
        System.out.println("\t1. 입금");
        System.out.println("\t2. 출금");
        System.out.println("\t3. 이체");
        System.out.println("\t0. 종료");
        System.out.println("---------------------------------");
        System.out.print(">사용하실 항목 번호를 선택하세요 : ");
        int num = sc.nextInt();

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

        return num;
    }

    public void showHead() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-14s %-13s %-10s %-10s %-20s\n", "ID", "계좌 별칭", "계좌번호", "은행", "계좌주명", "잔금");
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void execute() {


        UserUI userUI = new UserUI();
        userUI.loginEnvironment();

        LoginUI lu = new LoginUI();
        UserVO userVO = lu.loginUI();


        if (userVO != null) {
            switch (chooseMenu()) {
                case 1:
                    SelectAllAccountUI saau = new SelectAllAccountUI();
                    saau.selectAllAcountUI(userVO);
                    break;

                case 2:
                    SelectAccountUI sau = new SelectAccountUI();
                    sau.selectAcountUI(userVO);
                    break;

                case 3:

                    int num = chooseSubMenu();

                    if (num == 1) {
                        DepositUI du = new DepositUI();
                        du.depositUI(userVO);
                    } else if (num == 2) {
                        WithdrawUI wu = new WithdrawUI();
                        wu.withdrawUI(userVO);
                    } else if (num == 3) {
                        TransferUI tu = new TransferUI();
                        tu.transferUI(userVO);
                    } else {
                        new WrongInput().wrongInput();
                    }
                    break;


                case 4:
                    RegisterAccountUI rgau = new RegisterAccountUI();
                    rgau.registerAccountUI(userVO);
                    break;

                case 5:
                    CreateNewAccountUI cnau = new CreateNewAccountUI();
                    cnau.createNewAccountUI(userVO);
                    break;

                case 6:
                    ReviseAccountUI rau = new ReviseAccountUI();
                    rau.reviseAccountUI(userVO);
                    break;


                case 7:
                    DeleteAccountUI dau = new DeleteAccountUI();
                    dau.deleteAccountUI(userVO);
                    break;

                case 0:
                    new WrongInput().wrongInput();
                    break;

                default:

            }
        } else {
            System.out.println("프로그램이 종료됩니다.");
        }
    }


}
