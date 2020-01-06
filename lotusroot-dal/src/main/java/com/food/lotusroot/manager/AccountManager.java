package com.food.lotusroot.manager;

import com.food.lotusroot.dal.Account;

import java.util.List;

/**
 * <p>描述</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 4:08 PM
 * @since V1.0
 */
public interface AccountManager {

    List<Account> selectAll(Long accountId) ;

    List<Account> selectAllPage(Integer pageNo,Integer pageSize);
}
