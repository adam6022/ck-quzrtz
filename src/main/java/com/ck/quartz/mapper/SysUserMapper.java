package com.ck.quartz.mapper;

import com.ck.quartz.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-01 16:16
 */
@Mapper
public interface SysUserMapper {

    /**
     * 根据条件分页查询用户对象
     *
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser sysUser);


}
