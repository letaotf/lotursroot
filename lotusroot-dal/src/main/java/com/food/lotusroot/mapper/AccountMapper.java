package com.food.lotusroot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.food.lotusroot.dal.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>账户Mapper</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 2:53 PM
 * @since V1.0
 */
@Repository
public interface AccountMapper extends BaseMapper<Account>{

    List<Account> selectAll(Long accountId);
}
