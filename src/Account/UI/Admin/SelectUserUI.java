package Account.UI.Admin;

import Account.Service.AdminService;

import java.util.Scanner;

public class SelectUserUI extends BaseAdminUI{
    Scanner sc = new Scanner(System.in);


    public void adminExecute() throws Exception {

        AdminService adminService = new AdminService();
        String name = null;

        System.out.print(">조회할 계정의 ID를 입력하세요 : ");
        String tempId = sc.nextLine();

        name = adminService.selectUser(tempId);

        if (name == null) {
            System.out.println("조회되는 ID가 없습니다.");
            System.out.println("조회 서비스를 종료합니다.");
        } else {
            new AdminUI().adminShowHead();
            System.out.printf("%-10s %-15s\n", tempId, name);
        }
    }

}
