package IntegratedAccount.UI.User;

import IntegratedAccount.VO.UserVO;

public class UserUI extends BaseUserUI {

    public void userLoginEnvironment() {

        System.out.println("==================================");
        System.out.println("\t[사용자 로그인 화면] ");
        System.out.println("==================================");

    }

    public UserVO userExecute() throws Exception {

        userLoginEnvironment();
        UserVO userVO = null;
        userVO = new LoginUserUI().userExecute();


        return userVO;
    }


}
