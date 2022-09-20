package com.spring.dao.impl;

import com.spring.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    @Override
    public  void saveAccount(){

        System.out.println("保存了账户");
    }
}
