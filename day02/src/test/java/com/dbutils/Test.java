package com.dbutils;

import com.dbutils.dao.IAccountDao;
import com.dbutils.dao.impl.AccountDaoImpl;
import com.dbutils.domain.Account;

import java.util.List;

/**
 * 测试
 */
public class Test {

    public static void main(String[] args) {

//        Account account = new Account();
//        account.setName("ddd");
//        account.setMoney(2345f);
        IAccountDao accountDao = new AccountDaoImpl();
//        accountDao.save(account);
//        Account account = accountDao.findById(1);
//        System.out.println(account);
        List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
    }
}

