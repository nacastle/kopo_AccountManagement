package User.UserUI;

import User.UserDAO.UserDAO;
import User.UserVO.UserVO;

import java.util.Scanner;

public class LoginUI {
    //To do list: 로그인 할 ui 구현
    Scanner sc = new Scanner(System.in);

    public UserVO loginUI() {

        UserVO userVO = null;

        System.out.print(">id를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print(">pwd를 입력하세요: ");
        String pwd = sc.nextLine();

        UserDAO userDAO = new UserDAO();
//        boolean isLogin = userDAO.loginSys(id,pwd);

        if (userDAO.loginSys(id,pwd) != null) {
            System.out.println("로그인에 성공했습니다.");
            userVO = userDAO.loginSys(id,pwd);
        } else {
            System.out.println("일치하는 id, pwd가 없습니다.");
        }
        return userVO;
    }


}
