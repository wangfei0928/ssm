package com.wf.service.impl;

import com.wf.dao.AccountDao;
import com.wf.domain.Account;
import com.wf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    //需要用到AccountDao的代理对象
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        List<Account> all = accountDao.findAll();
        return all;
    }

    /*
    * 账户添加
    * */
    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        accountDao.deleteBatch(ids);
    }


}
