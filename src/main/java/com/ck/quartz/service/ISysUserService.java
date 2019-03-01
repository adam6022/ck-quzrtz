package com.ck.quartz.service;

import com.ck.quartz.domain.SysUser;

import java.util.List;


public interface ISysUserService {

    /**
     * 根据条件分页查询用户对象
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);

}
