package IntegratedAccount.UI.Admin;

import IntegratedAccount.Service.Admin.AdminService;
import IntegratedAccount.VO.UserVO;

import java.util.List;

public class SelectAllUserUI extends BaseAdminUI{

    public void adminExecute() throws Exception {

        List<UserVO> userVOList = new AdminService().selectAllUser();

        if (userVOList == null) {
            System.out.println("조회할 사용자 리스트가 없습니다.");
            System.out.println("조회 서비스를 종료합니다.");
        } else {
            new AdminUI().adminShowHead();
            for (UserVO userVO : userVOList) {
                String id = userVO.getId();
                String name = userVO.getName();

                System.out.printf("%-10s %-15s\n", id, name);
            }
        }
    }

}

