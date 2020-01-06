package com.food.lotusroot.web.controller;

import com.food.lotusroot.core.service.AccountService;
import com.food.lotusroot.dal.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>描述</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 3:14 PM
 * @since V1.0
 */
@RestController
@RequestMapping("account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/queryAccount.json")
    public List<Account> queryAccount(Long accountId){
        return accountService.selectAll(accountId);
    }
}
