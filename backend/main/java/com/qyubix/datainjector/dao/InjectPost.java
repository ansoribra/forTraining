package com.qyubix.datainjector.dao;

import com.github.javafaker.Faker;
import com.qyubix.QyubixApplication;
import com.qyubix.dao.PostDao;
import com.qyubix.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class InjectPost {

    @Autowired
    private PostDao post;

    @CrossOrigin
    @RequestMapping(value = "/injectpost",method = RequestMethod.GET)
    public String testInsert() {
        int totalData = 0;
        for(int i = 0; i<100;i++) {
            try {
                Faker faker = new Faker();
                Post s = new Post();
                s.setPost_date(faker.date().past(99999, TimeUnit.DAYS));
                s.setPost_author(faker.name().fullName());
                s.setPost_content(faker.chuckNorris().fact());
                s.setPost_link(faker.company().logo());
                post.save(s);
            }catch (Exception ex){
                continue;
            }
        }
        System.out.println("Finish injected data "+totalData+" injected to Post table");
        return totalData+" new data injected to Post table";
    }
}
