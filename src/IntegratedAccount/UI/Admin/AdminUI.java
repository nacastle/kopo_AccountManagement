package IntegratedAccount.UI.Admin;

import IntegratedAccount.UI.Account.AccountUI;
import IntegratedAccount.UI.zExtra.ExitUI;
import IntegratedAccount.UI.User.LoginUserUI;
import IntegratedAccount.UI.zExtra.WrongInput;
import IntegratedAccount.VO.UserVO;

import java.util.Scanner;

public class AdminUI extends BaseAdminUI{

    Scanner sc = new Scanner(System.in);

    public void adminLoginEnvironment() {

        System.out.println("==================================");
        System.out.println("\t[관리자 로그인 화면] ");
        System.out.println("==================================");

    }

    public String startEnvironment() {

        System.out.println("==================================");
        System.out.println("\t[시작 메뉴] ");
        System.out.println("==================================");
        System.out.println("\t1. 사용자 모드");
        System.out.println("\t2. 관리자 모드");
        System.out.println("\t0. 프로그램 종료");
        System.out.println("==================================");

        System.out.print(">진행할 모드를 선택하세요 : ");
        String num = sc.nextLine();

        return num;
    }

    public String adminEnvironment() {
        System.out.println("==================================");
        System.out.println("\t[관리자 모드] ");
        System.out.println("==================================");
        System.out.println("\t1. 전체 사용자 조회");
        System.out.println("\t2. 사용자 조회");
        System.out.println("\t3. 사용자 수정");
        System.out.println("\t4. 사용자 삭제");
        System.out.println("\t0. 프로그램 종료");
        System.out.println("==================================");
        System.out.print(">사용할 기능을 선택하세요 : ");
        String num = sc.nextLine();

        return num;

    }

    public void adminShowHead() {
        System.out.println("--------------------------------------------");
        System.out.printf("%-7s %-14s\n", "사용자ID", "사용자 이름");
        System.out.println("--------------------------------------------");
    }


    public void adminExecute() throws Exception {

        IAdminUI iau = null;

        while (true) {
            String startNum = startEnvironment();
            switch (startNum) {
                case "1":
                    UserVO userVO = new UserVO();
                    userVO = new LoginUserUI().userExecute();
                    new AccountUI().accountExecute(userVO);
                    break;

                case "2":
                    new LoginAdminUI().adminExecute();
                    while (true) {
                        loop1:
                        while (true) {
                            String adminNum = adminEnvironment();
                            switch (adminNum) {
                                case "1":
                                    iau = new SelectAllUserUI();
                                    break loop1;
                                case "2":
                                    iau = new SelectUserUI();
                                    break loop1;
                                case "3":
                                    iau = new ReviseUserUI();
                                    break loop1;
                                case "4":
                                    iau = new DeleteUserUI();
                                    break loop1;
                                case "0":
                                    new ExitUI().exitUI();
                                    System.exit(0);
                                default:
                                    new WrongInput().wrongInput();
                            }
                        }
                        iau.adminExecute();
                    }

                case "0":
                    new ExitUI().exitUI();
                    System.exit(0);
                default:
                    new WrongInput().wrongInput();
            }

        }
    }
}
