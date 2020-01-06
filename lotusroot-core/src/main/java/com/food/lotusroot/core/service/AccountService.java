package com.food.lotusroot.core.service;

import com.food.lotusroot.dal.Account;

import java.util.List;

/**
 * <p>账户服务</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 3:08 PM
 * @since V1.0
 */
public interface AccountService {

    List<Account> selectAll(Long accountId);
}
