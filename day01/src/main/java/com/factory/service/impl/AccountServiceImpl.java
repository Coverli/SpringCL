package com.factory.service.impl;

import com.factory.dao.IAccountDao;
import com.factory.factory.BeanFactory;
import com.factory.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

//    private int i = 1;

    @Override
    public void  saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
