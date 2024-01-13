package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Test
    public void findOne() {
        ProductInfo productInfo = productServiceImpl.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productServiceImpl.findAll(pageRequest);
        Assert.assertNotEquals(0, productInfoPage.getSize());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productServiceImpl.findUpAll();
        Assert.assertNotEquals(0, productInfoList);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("9876543");
        productInfo.setProductName("..不高兴");
        productInfo.setProductPrice(new BigDecimal(15.00));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("没什么可高兴的..");
        productInfo.setProductIcon(".jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        productInfo.setCreateTime(new Date());
        productInfo.setUpdateTime(new Date());
        ProductInfo productInfos = productServiceImpl.save(productInfo);
        Assert.assertEquals("9876543", productInfos.getProductId());
    }
}