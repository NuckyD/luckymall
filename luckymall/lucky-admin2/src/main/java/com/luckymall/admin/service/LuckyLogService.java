package com.luckymall.admin.service;

import com.github.pagehelper.PageHelper;
import com.luckymall.admin.dao.LuckyLogMapper;
import com.luckymall.admin.entity.LuckyLog;
import com.luckymall.admin.entity.LuckyLogExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LuckyLogService {
    @Resource
    private LuckyLogMapper logMapper;

    public void deleteById(Integer id) {
        logMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LuckyLog log) {
        log.setAddTime(LocalDateTime.now());
        log.setUpdateTime(LocalDateTime.now());
        logMapper.insertSelective(log);
    }

    public List<LuckyLog> querySelective(String name, Integer page, Integer size, String sort, String order) {
        LuckyLogExample example = new LuckyLogExample();
        LuckyLogExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andAdminLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return logMapper.selectByExample(example);
    }
}
