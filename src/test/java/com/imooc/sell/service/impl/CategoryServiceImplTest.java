package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryServiceImpl.findOne(2);
        Assert.assertEquals(new Integer(2), productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = categoryServiceImpl.findAll();
        Assert.assertNotEquals(0, productCategories);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategories = categoryServiceImpl.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertNotEquals(0, productCategories);
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("这是test :" + CategoryServiceImpl.class);
        productCategory.setCategoryType(4);
        productCategory.setCreateTime(new Date());
        productCategory.setUpdateTime(new Date());
        ProductCategory result = categoryServiceImpl.save(productCategory);
        Assert.assertNotNull(result);
    }
}