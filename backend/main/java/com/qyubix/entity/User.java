package com.qyubix.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Entity
public class User{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String user_name;

    @Email
    private String user_email;


    private String user_password;

    @Past
    private Date user_birth;

    private Date user_active_from;
    private String user_status;
    private Date user_last_login;
    private String user_activity;
    private int user_star;
    private String user_role;

    @OneToMany(mappedBy = "store_user_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Store> user_store_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Date getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(Date user_birth) {
        this.user_birth = user_birth;
    }

    public Date getUser_active_from() {
        return user_active_from;
    }

    public void setUser_active_from(Date user_active_from) {
        this.user_active_from = user_active_from;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public Date getUser_last_login() {
        return user_last_login;
    }

    public void setUser_last_login(Date user_last_login) {
        this.user_last_login = user_last_login;
    }

    public String getUser_activity() {
        return user_activity;
    }

    public void setUser_activity(String user_activity) {
        this.user_activity = user_activity;
    }

    public int getUser_star() {
        return user_star;
    }

    public void setUser_star(int user_star) {
        this.user_star = user_star;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public List<Store> getUser_store_id() {
        return user_store_id;
    }

    public void setUser_store_id(List<Store> user_store_id) {
        this.user_store_id = user_store_id;
    }
}
