package com.food.lotusroot.dal;

import lombok.Data;

/**
 * <p>账户</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 2:52 PM
 * @since V1.0
 */
@Data
public class Account {

    private Long accountId;

    private String accountName;

    private String mobile;

    private Integer sex;
}
