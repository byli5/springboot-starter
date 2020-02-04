package com.imooc.service;

import com.github.pagehelper.PageHelper;
import com.imooc.mapper.SysUserMapper;
import com.imooc.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public void saveUser(SysUser sysUser) throws Exception {
        userMapper.insert(sysUser);

    }

    @Override
    public void updateUser(SysUser user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public SysUser queryUserById(String userId) {
        return null;
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        return null;
    }

    @Override
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        List list = new  ArrayList();
        list.add("agg");

        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> userList = userMapper.selectByExample(example);

        return userList;
    }

    @Override
    public SysUser queryUserByIdCustom(String userId) {
        return null;
    }

    @Override
    public void saveUserTransactional(SysUser user) {

    }
}
