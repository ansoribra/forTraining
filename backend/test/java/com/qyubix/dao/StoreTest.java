package com.qyubix.dao;

import com.github.javafaker.Faker;
import com.qyubix.QyubixApplication;
import com.qyubix.entity.Store;
import com.qyubix.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = QyubixApplication.class)
public class StoreTest {

    @Autowired
    private StoreDao store;


    @Autowired
    private UserDao user;

    @Test
    public void testInsert() {
        for (User model:user.findAll()) {
                try {
                    Faker faker = new Faker();
                    Store s = new Store();
                    s.setStore_id(faker.company().name().replaceAll("\\W.*", ""));
                    s.setStore_created(faker.date().past(9999, TimeUnit.DAYS));
                    s.setStore_delivery("yes");
                    s.setStore_description(faker.lorem().paragraph());
                    s.setStore_last_login(faker.date().past(999999, TimeUnit.HOURS));
                    s.setStore_location(faker.address().streetAddress());
                    s.setStore_name(faker.commerce().productName());
                    s.setStore_password(faker.crypto().md5());
                    s.setStore_phone_number(faker.phoneNumber().cellPhone());
                    s.setStore_product(faker.commerce().department().replaceAll("\\W.*", ""));
                    s.setStore_risk(faker.number().numberBetween(1, 10));
                    s.setStore_star(faker.number().numberBetween(1, 10));
                    s.setStore_status("active");
                    s.setStore_viewed(faker.number().numberBetween(1, 999999999));
                    s.setStore_user_id(model);
                    store.save(s);
                } catch (Exception ex) {
                    continue;
                }
        }
    }
}
