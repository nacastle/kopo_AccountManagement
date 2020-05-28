package IntegratedAccount.UI.Admin;

import IntegratedAccount.Service.Admin.AdminService;

import java.util.Scanner;

public class ReviseUserUI extends BaseAdminUI{

    Scanner sc = new Scanner(System.in);

    public void adminExecute() throws Exception {

        AdminService adminService = new AdminService();

        System.out.print(">변경할 계정의 ID를 입력하세요 : ");
        String id = sc.nextLine();

        String originalName = adminService.selectUser(id);

        if (originalName == null) {
            System.out.println("조회되는 계정이 없습니다.");
            System.out.println("이름 수정 서비스를 종료합니다.");
        } else {
            while (true) {
                System.out.print(">새로운 이름을 입력하세요 : ");
                String newName = sc.nextLine();
                if (!newName.equals(originalName)) {
                    adminService.reviseAccountDAO(id, newName);
                    System.out.printf("'%s'에서 '%s'(으)로 이름이 변경되었습니다.\n", originalName, newName);
                    break;
                } else {
                    System.out.println("기존의 이름과 동일합니다. 다시 입력하세요.");
                }
            }
        }


    }

}
