package Account.UI.Admin;

import Account.Service.AdminService;

import java.util.Scanner;

public class LoginAdminUI extends BaseAdminUI{


    Scanner sc = new Scanner(System.in);

    public void adminExecute() throws Exception {

        int isLogin = 0;
        AdminService adminService = new AdminService();

        while (true) {

            new AdminUI().adminLoginEnvironment();

            System.out.print(">ID를 입력하세요: ");
            String id = sc.nextLine();
            System.out.print(">PASSWORD를 입력하세요: ");
            String pwd = sc.nextLine();

            isLogin = adminService.loginAdminSys(id,pwd);

            if (isLogin != 0) {
                System.out.println("로그인에 성공했습니다.");
                break;
            } else {
                System.out.println("일치하는 ID, PASSWORD가 없습니다. 다시 입력해주세요.");
            }
        }
    }
}
