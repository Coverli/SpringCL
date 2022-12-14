package com.dbutils.dao.impl;

import com.dbutils.dao.IAccountDao;
import com.dbutils.domain.Account;
import com.dbutils.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 账户的持久层操作
 */
public class AccountDaoImpl implements IAccountDao{

    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());

    @Override
    public void save(Account account) {
        try {
            runner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer accountId) {
        try {
            runner.update("delete from account where id=?",accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Account findById(Integer accountId) {
        try {
            return (Account)runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Account> findAll() {
        try {
            return (List<Account>)runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
