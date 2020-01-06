package com.food.lotusroot.mapper;

import com.food.lotusroot.dal.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * <p>账户Mapper</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 2:53 PM
 * @since V1.0
 */
@Mapper
public interface AccountMapper {

    List<Account> selectAll(Long accountId);

    List<Account> selectAllPage(RowBounds rowBounds);
}
