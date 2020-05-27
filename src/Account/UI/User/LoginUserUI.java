package Account.UI.User;

import Account.Service.UserService;
import Account.VO.UserVO;

import java.util.Scanner;

public class LoginUserUI extends BaseUserUI {
    //To do list: 로그인 할 ui 구현
    Scanner sc = new Scanner(System.in);

    public UserVO userExecute() {

        UserVO userId = null;
        UserService userService = new UserService();

        while (true) {

            new UserUI().userLoginEnvironment();

            System.out.print(">ID를 입력하세요: ");
            String id = sc.nextLine();
            System.out.print(">PASSWORD를 입력하세요: ");
            String pwd = sc.nextLine();


            userId = userService.loginSys(id,pwd);

            if (userId != null) {
                System.out.println("로그인에 성공했습니다.");
                break;
            } else {
                System.out.println("일치하는 ID, PASSWORD가 없습니다. 다시 입력해주세요.");
            }
        }
        return userId;
    }


}
