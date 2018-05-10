package com.zxb.xunzu.repository;

import com.zxb.xunzu.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *角色数据dao
 * Created by xuery on 2018/5/10.
 */
public interface RoleRepository extends CrudRepository<Role, Long>{

    List<Role> findRolesByUserId(Long userId);

}
