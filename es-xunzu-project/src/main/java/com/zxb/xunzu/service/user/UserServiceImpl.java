package com.zxb.xunzu.service.user;

import com.google.common.collect.Lists;
import com.zxb.xunzu.entity.Role;
import com.zxb.xunzu.entity.User;
import com.zxb.xunzu.repository.RoleRepository;
import com.zxb.xunzu.repository.UserRepository;
import com.zxb.xunzu.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xuery on 2018/5/10.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);
        if (user == null) {
            return null;
        }

        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
        if (CollectionUtils.isEmpty(roles)) {
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorityList(authorities);

        return user;
    }

    @Override
    public User findUserByTelephone(String telephone) {
        User user = userRepository.findUserByPhoneNumber(telephone);
        if (user == null) {
            return null;
        }

        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
        if (CollectionUtils.isEmpty(roles)) {
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorityList(authorities);

        return user;
    }

    @Override
    public User addUserByTelephone(String telephone) {
        User user = new User();
        user.setPhoneNumber(telephone);
        user.setName(telephone.substring(0, 3) + "****" + telephone.substring(7, telephone.length()));
        Date now = new Date();
        user.setCreateTime(now);
        user.setLastUpdateTime(now);
        user.setLastLoginTime(now);
        user = userRepository.save(user);

        Role role = new Role();
        role.setName("USER");
        role.setUserId(user.getId());
        roleRepository.save(role);
        user.setAuthorityList(Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER")));
        return user;
    }
}
