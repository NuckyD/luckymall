package com.luckymall.admin.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.luckymall.admin.dao.LuckyRoleMapper;
import com.luckymall.admin.entity.LuckyRole;
import com.luckymall.admin.entity.LuckyRoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LuckyRoleService {
    @Resource
    private LuckyRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        LuckyRoleExample example = new LuckyRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<LuckyRole> roleList = roleMapper.selectByExample(example);

        for(LuckyRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<LuckyRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        LuckyRoleExample example = new LuckyRoleExample();
        LuckyRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public LuckyRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(LuckyRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(LuckyRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        LuckyRoleExample example = new LuckyRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<LuckyRole> queryAll() {
        LuckyRoleExample example = new LuckyRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
