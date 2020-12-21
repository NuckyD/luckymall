package com.luckymall.goods.service;

import com.github.pagehelper.PageHelper;
import com.luckymall.goods.dao.LuckyCategoryMapper;
import com.luckymall.goods.entity.LuckyCategory;
import com.luckymall.goods.entity.LuckyCategoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LuckyCategoryService {
    @Resource
    private LuckyCategoryMapper categoryMapper;
    private LuckyCategory.Column[] CHANNEL = {LuckyCategory.Column.id, LuckyCategory.Column.name, LuckyCategory.Column.iconUrl};

    public List<LuckyCategory> queryL1WithoutRecommend(int offset, int limit) {
        LuckyCategoryExample example = new LuckyCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<LuckyCategory> queryL1(int offset, int limit) {
        LuckyCategoryExample example = new LuckyCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<LuckyCategory> queryL1() {
        LuckyCategoryExample example = new LuckyCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<LuckyCategory> queryByPid(Integer pid) {
        LuckyCategoryExample example = new LuckyCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<LuckyCategory> queryL2ByIds(List<Integer> ids) {
        LuckyCategoryExample example = new LuckyCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public LuckyCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<LuckyCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        LuckyCategoryExample example = new LuckyCategoryExample();
        LuckyCategoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return categoryMapper.selectByExample(example);
    }

    public int updateById(LuckyCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LuckyCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<LuckyCategory> queryChannel() {
        LuckyCategoryExample example = new LuckyCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
