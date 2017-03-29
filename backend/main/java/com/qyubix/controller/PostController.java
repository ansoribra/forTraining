package com.qyubix.controller;

import com.qyubix.dao.PostDao;
import com.qyubix.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    private PostDao post;

    //GET METHOD========================================================================================================
    @RequestMapping(value = "/post",method = RequestMethod.GET)
    public Page<Post> getAllPost(Pageable page){
        return post.findAll(page);
    }

    @RequestMapping(value = "/post", params = "post_author", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Post> findByAuthor(@RequestParam("post_author") String postAuthor) {
        PageRequest page = new PageRequest(0, 5);
        return post.findByPostAuthor(postAuthor, page);
    }

    @RequestMapping(value = "/post", params = "post_content", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Post> findByContent(@RequestParam("post_content") String postContent) {
        PageRequest page = new PageRequest(0, 5);
        return post.findByPostContent(postContent, page);
    }

    @RequestMapping(value = "/postp", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Post> findByDatey(@RequestParam(value = "post_date", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date postDate,
                                  @RequestParam(value = "day", defaultValue = "0") int day,
                                  @RequestParam(value = "month", defaultValue = "0") int month,
                                  @RequestParam(value = "year", defaultValue = "0") int year) {
        PageRequest page = new PageRequest(0, 5);
        if (day!=0){
            return post.findByPostDateDay(day, page);
        }else if (month!=0){
            return post.findByPostDateMonth(month, page);
        }else if (year!=0){
            return post.findByPostDateYear(year, page);
        }else{
            return post.findByPostDate(postDate, page);
        }
    }

    @RequestMapping(value = "/post", params = "post_link", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Post> findByLink(@RequestParam("post_link") String postLink) {
        PageRequest page = new PageRequest(0, 5);
        return post.findByPostLink(postLink, page);
    }

    //POST METHOD=======================================================================================================
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertNewPost(@RequestBody Post p){
        post.save(p);
    }
    //PUT METHOD========================================================================================================
    @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable("id") String id,@RequestBody Post p){
        p.setId(id);
        post.save(p);
    }

    //DELETE METHOD=====================================================================================================
    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable("id") String id){
        post.delete(id);
    }
}
