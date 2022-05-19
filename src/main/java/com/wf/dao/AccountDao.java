package com.wf.dao;

import com.wf.domain.Account;

import java.util.List;

public interface AccountDao {

    /*查询所有用户*/
    public List<Account> findAll();

    public void save(Account account);

    public Account findById(Integer id);

    public void update(Account account);

    public void deleteBatch(Integer [] ids);
}
