package com.food.lotusroot.manager;

import com.food.lotusroot.dal.Account;
import com.food.lotusroot.mapper.AccountMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>描述</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 4:09 PM
 * @since V1.0
 */
@Component
public class AccountManagerImpl implements AccountManager{

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> selectAll(Long accountId) {
        return accountMapper.selectAll(accountId);
    }

    @Override
    public List<Account> selectAllPage(Integer pageNo,Integer pageSize) {
        return accountMapper.selectAllPage(new RowBounds(pageNo,pageSize));
    }
}
