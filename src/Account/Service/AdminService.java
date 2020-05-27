package Account.Service;

import Account.DAO.AdminDAO;
import Account.VO.UserVO;

import java.util.List;

public class AdminService {

    private AdminDAO adminDAO;

    public AdminService() {
        adminDAO = new AdminDAO();
    }


    public int loginAdminSys(String id, String pwd) {

        int isLogin = 0;
        isLogin = adminDAO.loginAdminSysDAO(id, pwd);

        return isLogin;
    }

    public List<UserVO> selectAllUser() {
        List<UserVO> userVOList = null;
        userVOList = adminDAO.selectAllUserDAO();

        return userVOList;
    }

    public String selectUser(String tempId) {

        String name = null;
        name = adminDAO.selectUserDO(tempId);

        return name;
    }

    public void deleteUser(String tempId) {

        adminDAO.deleteUserDAO(tempId);
    }

    public void reviseAccountDAO(String tempId, String newName) {

        adminDAO.reviseAccountDAO(tempId, newName);
    }


}
