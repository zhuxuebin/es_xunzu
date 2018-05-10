package com.zxb.xunzu.service.user;

import com.zxb.xunzu.entity.User;

/**
 * Created by xuery on 2018/5/10.
 */
public interface IUserService {

    User findUserByName(String userName);

    User findUserByTelephone(String telephone);

    User addUserByTelephone(String telephone);


}
