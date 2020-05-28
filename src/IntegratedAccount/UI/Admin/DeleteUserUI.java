package IntegratedAccount.UI.Admin;

import IntegratedAccount.Service.Admin.AdminService;

import java.util.Scanner;

public class DeleteUserUI extends BaseAdminUI{
    Scanner sc = new Scanner(System.in);

    public void adminExecute() throws Exception {

        AdminService adminService = new AdminService();

        System.out.print(">삭제할 계정의 ID를 입력하세요 : ");
        String id = sc.nextLine();

        if (adminService.selectUser(id) == null) {
            System.out.println("조회되는 계정이 없습니다.");
            System.out.println("삭제 서비스를 종료합니다.");
        } else {
            adminService.deleteUser(id);
            System.out.printf("'%s' 계정이 삭제되었습니다.\n", id);
        }

    }

}
