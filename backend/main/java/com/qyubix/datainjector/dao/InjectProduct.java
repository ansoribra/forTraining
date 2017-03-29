package com.qyubix.datainjector.dao;

import com.github.javafaker.Faker;
import com.qyubix.QyubixApplication;
import com.qyubix.dao.ProductDao;
import com.qyubix.dao.StoreDao;
import com.qyubix.entity.Product;
import com.qyubix.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class InjectProduct {

    @Autowired
    private ProductDao product;

    @Autowired
    private StoreDao store;

    @CrossOrigin
    @RequestMapping(value = "/injectproduct",method = RequestMethod.GET)
    public String testInsert() {
        int totalData =0;
        for (Store model:store.findAll()) {
            int hapus=0;
            Random random = new Random();
            int randomVal = (random.nextInt(20)+1);
            for(int i =1; i < randomVal;i++) {
                try {
                    System.out.println("Nilai Random : "+randomVal);
                    System.out.println(++hapus);
                    Faker faker = new Faker();
                    Product p = new Product();
                    p.setProduct_category(faker.commerce().department());
                    p.setProduct_description(faker.lorem().sentence(400));
                    p.setProduct_discount(faker.number().numberBetween(1, 70));
                    p.setProduct_name(faker.commerce().productName());
                    p.setProduct_price(faker.number().numberBetween(5000, 999999999));
                    p.setProduct_rating(faker.number().numberBetween(1, 10));
                    p.setProduct_sold(faker.number().numberBetween(1, 9999999));
                    double discounthasil= p.getProduct_price()-(((double)p.getProduct_discount() /100)*p.getProduct_price());
                    p.setProduct_discount_after((int)discounthasil) ;
                    p.setProduct_store_id(model.getStore_id());
                    p.setProduct_image_total(faker.number().numberBetween(1, 10));
                    product.save(p);
                    totalData++;
                } catch (Exception ex) {
                    continue;
                }
            }
        }
        System.out.println("Finish injected data "+totalData+" injected to Product table");
        return totalData+" new data injected to Product table";
    }
}