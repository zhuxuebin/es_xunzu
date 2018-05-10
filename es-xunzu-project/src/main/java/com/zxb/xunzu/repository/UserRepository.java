package com.zxb.xunzu.repository;

import com.zxb.xunzu.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xuery on 2018/5/9.
 */
//<vo对象, 主键类型
public interface UserRepository extends CrudRepository<User, Long> {

    //函数名应该是约定好的
    User findByName(String userName);

    User findUserByPhoneNumber(String telephone);
}
