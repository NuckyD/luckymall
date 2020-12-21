package com.luckymall.goods.dto;

import com.luckymall.goods.entity.LuckyGoods;
import com.luckymall.goods.entity.LuckyGoodsAttribute;
import com.luckymall.goods.entity.LuckyGoodsProduct;
import com.luckymall.goods.entity.LuckyGoodsSpecification;

public class GoodsAllinone {
    LuckyGoods goods;
    LuckyGoodsSpecification[] specifications;
    LuckyGoodsAttribute[] attributes;
    LuckyGoodsProduct[] products;

    public LuckyGoods getGoods() {
        return goods;
    }

    public void setGoods(LuckyGoods goods) {
        this.goods = goods;
    }

    public LuckyGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(LuckyGoodsProduct[] products) {
        this.products = products;
    }

    public LuckyGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(LuckyGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public LuckyGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(LuckyGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}
