package IntegratedAccount.Service.Account;

import IntegratedAccount.DAO.*;
import IntegratedAccount.VO.AccountVO;
import IntegratedAccount.VO.UserVO;

import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public List<AccountVO> selectAllAccount(UserVO userVO) {

        List<AccountVO> accountList = null;
        accountList = accountDAO.selectAllAccountDAO(userVO);

        return accountList;
    }

    public List<AccountVO> selectAccountByNickOrBank(UserVO userVO, String nickOrBank) {

        List<AccountVO> accountVOList = null;

        accountVOList = accountDAO.selectAccountDAO(userVO, nickOrBank);

        return accountVOList;
    }

    public AccountVO selectAccountByAccountNumber(UserVO userVO, int accountNumber) {

        AccountVO accountVO = null;
        accountVO = accountDAO.selectAccountDAO(userVO, accountNumber);

        return accountVO;
    }

    public AccountVO selectAccount(int accountNumber) {

        AccountVO accountVO = null;
        accountVO = accountDAO.selectAccountDAO(accountNumber);

        return accountVO;
    }

    public AccountVO selectAccount(String id) {

        AccountVO accountVO = null;
        accountVO = accountDAO.selectAccountDAO(id);

        return accountVO;
    }


    public void deposit(UserVO userVO, long originalBalance, long depositAmount, int tempAccountNumber) {

        accountDAO.depositDAO(userVO, originalBalance, depositAmount, tempAccountNumber);
    }

    public void withdraw(UserVO userVO, long originalBalance, long depositAmount, int tempAccountNumber) {

        accountDAO.withdrawDAO(userVO, originalBalance, depositAmount, tempAccountNumber);
    }

    public void registerAccount(UserVO userVO, AccountVO accountVO){
        accountDAO.registerAccountDAO(userVO, accountVO);
    }

    public void reviseAccount(UserVO userVO, String newNickname, int tempAccountNumber){
        accountDAO.reviseAccountDAO(userVO, newNickname, tempAccountNumber);
    }

    public void deleteAccount(UserVO userVO, int accountNumber){
        accountDAO.deleteAccountDAO(userVO, accountNumber);
    }











}


