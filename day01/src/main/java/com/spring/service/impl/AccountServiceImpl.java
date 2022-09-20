package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao ;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    @Override
    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
