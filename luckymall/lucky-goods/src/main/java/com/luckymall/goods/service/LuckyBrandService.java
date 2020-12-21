package com.luckymall.goods.service;

import com.github.pagehelper.PageHelper;
import com.luckymall.goods.dao.LuckyBrandMapper;
import com.luckymall.goods.entity.LuckyBrand;
import com.luckymall.goods.entity.LuckyBrand.*;
import com.luckymall.goods.entity.LuckyBrandExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LuckyBrandService {
    @Resource
    private LuckyBrandMapper brandMapper;
    private Column[] columns = new Column[]{Column.id, Column.name, Column.desc, Column.picUrl, Column.floorPrice};

    public List<LuckyBrand> query(Integer page, Integer limit, String sort, String order) {
        LuckyBrandExample example = new LuckyBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public List<LuckyBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public LuckyBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public List<LuckyBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        LuckyBrandExample example = new LuckyBrandExample();
        LuckyBrandExample.Criteria criteria = example.createCriteria();

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
        return brandMapper.selectByExample(example);
    }

    public int updateById(LuckyBrand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LuckyBrand brand) {
        brand.setAddTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insertSelective(brand);
    }

    public List<LuckyBrand> all() {
        LuckyBrandExample example = new LuckyBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }
}
