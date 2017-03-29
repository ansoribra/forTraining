package com.qyubix.datainjector.dao;

import com.github.javafaker.Faker;
import com.qyubix.QyubixApplication;
import com.qyubix.dao.StoreDao;
import com.qyubix.dao.UserDao;
import com.qyubix.entity.Store;
import com.qyubix.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class InjectStore {

    @Autowired
    private StoreDao store;


    @Autowired
    private UserDao user;

    @CrossOrigin
    @RequestMapping(value = "/injectstore",method = RequestMethod.GET)
    public String testInsert() {
        int totalData =0;
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
                    totalData++;
                } catch (Exception ex) {
                    continue;
                }
        }
        System.out.println("Finish injected data "+totalData+" injected to Store table");
        return totalData+" new data injected to Store table";
    }
}
