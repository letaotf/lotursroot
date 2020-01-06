package com.food.lotusroot.core;

import com.food.lotusroot.core.service.AccountService;
import com.food.lotusroot.dal.Account;
import com.food.lotusroot.manager.AccountManager;
import com.food.lotusroot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>账户服务</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 3:08 PM
 * @since V1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountManager accountManager;

    @Override
    public List<Account> selectAll(Long accountId) {
        return accountManager.selectAll(accountId);
    }

    @Override
    public List<Account> selectAllPage(Integer pageNo, Integer pageSize) {
        return accountManager.selectAllPage(pageNo,pageSize);
    }
}
