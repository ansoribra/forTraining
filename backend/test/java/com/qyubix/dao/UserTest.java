package com.qyubix.dao;

import com.github.javafaker.Faker;
import com.qyubix.QyubixApplication;
import com.qyubix.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = QyubixApplication.class)
public class UserTest {

    @Autowired
    private UserDao user;

    @Test
    public void testInsert() {
        for(int i = 0; i<100;i++) {
            try {
                Faker faker = new Faker();
                User u = new User();
                u.setUser_active_from(faker.date().past(9999, TimeUnit.DAYS));
                u.setUser_activity(faker.lorem().paragraph());
                u.setUser_birth(faker.date().past(99999, TimeUnit.DAYS));
                u.setUser_email(faker.internet().emailAddress());
                u.setUser_last_login(faker.date().past(999, TimeUnit.DAYS));
                u.setUser_name((faker.name().fullName()).replaceAll("\\W",""));
                u.setUser_password(faker.crypto().md5());
                u.setUser_star(faker.number().numberBetween(1,10));
                u.setUser_status("active");
                user.save(u);
            }catch (Exception ex){
                continue;
            }
        }
    }
}
