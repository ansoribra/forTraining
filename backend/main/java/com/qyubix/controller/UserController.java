package com.qyubix.controller;

import com.qyubix.dao.UserDao;
import com.qyubix.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserDao useri;

    @RequestMapping("/user")
    @CrossOrigin
    public Page<User> getAllProduct(Pageable page){
        return useri.findAll(page);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    public String login(@RequestBody User login) throws ServletException, NoSuchAlgorithmException {

        String jwtToken = "";

        if (login.getUser_name() == null || login.getUser_password() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String username = login.getUser_name();
        String password = login.getUser_password();


        User user = useri.findByUserName(username);

        if (user == null) {
            throw new ServletException("User name not found.");
        }

        String pwd = user.getUser_password();

        if (!sha1(password).equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + 100000))
                .claim("role", "ROLE_ADMIN").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        System.out.println(jwtToken);
        jwtToken = "{\"token\": \"" + jwtToken + "\","+"\"user\": \""+user+"\" , \"role\":\"ROLE_ADMIN\"}";
        return jwtToken;
    }
    //POST METHOD=======================================================================================================
    //PUT METHOD========================================================================================================
    //DELETE METHOD=====================================================================================================

    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
