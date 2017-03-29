package com.qyubix.dao;

import com.qyubix.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.Date;

public interface PostDao extends PagingAndSortingRepository<Post,String> {

    @Query("select x from Post x where x.post_author like %:a%")
    public Page<Post> findByPostAuthor(@Param("a") String postAuthor, Pageable page);

    @Query("select x from Post x where x.post_content like %:a%")
    public Page<Post> findByPostContent(@Param("a") String postContent, Pageable page);

    @Query("select x from Post x where x.post_date = :a")
    public Page<Post> findByPostDate(@Param("a")  Date  postDate, Pageable page);

    @Query("select x from Post x where extract(year from x.post_date) = :a")
    public Page<Post> findByPostDateYear (@Param("a")  int  postDate, Pageable page);

    @Query("select x from Post x where extract(month from x.post_date) = :a")
    public Page<Post> findByPostDateMonth (@Param("a")  int  postDate, Pageable page);

    @Query("select x from Post x where extract(day from x.post_date) = :a")
    public Page<Post> findByPostDateDay (@Param("a")  int  postDate, Pageable page);

    @Query("select x from Post x where x.post_link like %:a%")
    public Page<Post> findByPostLink(@Param("a") String postLink, Pageable page);
}
