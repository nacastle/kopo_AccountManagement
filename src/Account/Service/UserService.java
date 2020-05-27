package Account.Service;

import Account.DAO.UserDAO;
import Account.VO.UserVO;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public UserVO loginSys(String id, String pwd) {

        UserVO userVO = null;
        userVO = userDAO.loginSysDAO(id, pwd);

        return userVO;
    }

}
