package com.luckymall.goods.service;

import com.luckymall.goods.dao.LuckyGoodsAttributeMapper;
import com.luckymall.goods.entity.LuckyGoodsAttribute;
import com.luckymall.goods.entity.LuckyGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LuckyGoodsAttributeService {
    @Resource
    private LuckyGoodsAttributeMapper goodsAttributeMapper;

    public List<LuckyGoodsAttribute> queryByGid(Integer goodsId) {
        LuckyGoodsAttributeExample example = new LuckyGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(LuckyGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public LuckyGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        LuckyGoodsAttributeExample example = new LuckyGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }

    public void deleteById(Integer id) {
        goodsAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(LuckyGoodsAttribute attribute) {
        attribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.updateByPrimaryKeySelective(attribute);
    }
}
