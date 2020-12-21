package com.luckymall.goods.service;

import com.luckymall.goods.dao.GoodsProductMapper;
import com.luckymall.goods.dao.LuckyGoodsProductMapper;
import com.luckymall.goods.entity.LuckyGoodsProduct;
import com.luckymall.goods.entity.LuckyGoodsProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LuckyGoodsProductService {
    @Resource
    private LuckyGoodsProductMapper LuckyGoodsProductMapper;
    @Resource
    private GoodsProductMapper goodsProductMapper;

    public List<LuckyGoodsProduct> queryByGid(Integer gid) {
        LuckyGoodsProductExample example = new LuckyGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return LuckyGoodsProductMapper.selectByExample(example);
    }

    public LuckyGoodsProduct findById(Integer id) {
        return LuckyGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        LuckyGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LuckyGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        LuckyGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        LuckyGoodsProductExample example = new LuckyGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) LuckyGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        LuckyGoodsProductExample example = new LuckyGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        LuckyGoodsProductMapper.logicalDeleteByExample(example);
    }

    public int addStock(Integer id, Short num){
        return goodsProductMapper.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProductMapper.reduceStock(id, num);
    }

    public void updateById(LuckyGoodsProduct product) {
        product.setUpdateTime(LocalDateTime.now());
        LuckyGoodsProductMapper.updateByPrimaryKeySelective(product);
    }
}