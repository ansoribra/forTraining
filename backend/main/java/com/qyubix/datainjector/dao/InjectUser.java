package com.qyubix.datainjector.dao;

import com.github.javafaker.Faker;
import com.qyubix.QyubixApplication;
import com.qyubix.dao.UserDao;
import com.qyubix.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class InjectUser {

    @Autowired
    private UserDao user;

    @CrossOrigin
    @RequestMapping(value = "/injectuser",method = RequestMethod.GET)
    public String testInsert() {
        int totalData =0;
        System.out.println("Injecting table");
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
                totalData++;
            }catch (Exception ex){
                continue;
            }
        }
        System.out.println("Finish injected data "+totalData+" injected to User table");
        return totalData+" new data injected to User table";
    }
}
