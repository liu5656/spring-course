package dadalang.service.impl;

import dadalang.dao.IAccountDao;
import dadalang.dao.impl.AccountDaoImpl;
import dadalang.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao dao = new AccountDaoImpl();
    public void saveAccount() {
        System.out.println("业务层保存业务");
        dao.saveAccount();
    }
}
