package com.ck.quartz.controller.slave;

import com.ck.quartz.controller.support.BaseController;
import com.ck.quartz.domain.SysUser;
import com.ck.quartz.service.ISysUserService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.page.TableDataInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/user")
@Api(value = "/system/user", tags = "用户管理")
public class SysUserController extends BaseController
{

    @Autowired
    private ISysUserService userService;




    @PostMapping("/list")
    @ResponseBody
    @DataSource(value = DataSourceType.SLAVE)
    public TableDataInfo list(SysUser user)
    {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }


}