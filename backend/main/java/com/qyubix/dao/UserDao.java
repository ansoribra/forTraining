package com.qyubix.dao;

import com.qyubix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserDao extends JpaRepository<User,String> {
    @Query("select x from User x where x.user_name = :a")
    public User findByUserName(@Param("a") String productCategory);
}
