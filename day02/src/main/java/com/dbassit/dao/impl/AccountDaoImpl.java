package com.dbassit.dao.impl;

import com.dbassit.dao.IAccountDao;
import com.dbassit.dbassit.DBAssit;
import com.dbassit.domain.Account;
import com.dbassit.handler.impl.BeanHandler;
import com.dbassit.handler.impl.BeanListHandler;
import com.dbassit.utils.C3P0Util;

import java.util.List;

/**
 * 账户的持久层操作
 */
public class AccountDaoImpl implements IAccountDao{

    private DBAssit dbAssit = new DBAssit(C3P0Util.getDataSource());

    @Override
    public void save(Account account) {
        dbAssit.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }

    @Override
    public void update(Account account) {
        dbAssit.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public void delete(Integer accountId) {
        dbAssit.update("delete from account where id=?",accountId);
    }

    @Override
    public Account findById(Integer accountId) {
        return (Account)dbAssit.query("select * from account where id = ?",new BeanHandler(Account.class),accountId);
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>)dbAssit.query("select * from account",new BeanListHandler(Account.class));
    }
}
