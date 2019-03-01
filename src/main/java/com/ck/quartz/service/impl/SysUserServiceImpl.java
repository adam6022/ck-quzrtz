package com.ck.quartz.service.impl;

import com.ck.quartz.domain.SysUser;
import com.ck.quartz.mapper.SysUserMapper;
import com.ck.quartz.service.ISysUserService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-01 16:15
 */
@Service
public class SysUserServiceImpl implements ISysUserService {


    @Autowired
    private SysUserMapper userMapper;


    /**
     * 根据条件分页查询用户对象
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
    public List<SysUser> selectUserList(SysUser user) {
        return userMapper.selectUserList(user);
    }
}
