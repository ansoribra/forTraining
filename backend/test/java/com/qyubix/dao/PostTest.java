package com.qyubix.dao;

import com.github.javafaker.Faker;
import com.qyubix.QyubixApplication;
import com.qyubix.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = QyubixApplication.class)
public class PostTest {

    @Autowired
    private PostDao post;

    @Test
    public void testInsert() {
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
    }
}
