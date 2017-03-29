package com.qyubix.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Store {

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false,unique = true)
    @NotNull
    private String store_id;

    @NotNull
    private String store_password;

    @NotNull
    private String store_name;

    private String store_product;

    @NotNull
    private String store_location;

    private String store_description;

    @NotNull
    private String store_phone_number;

    private String store_delivery;
    private String store_status;
    private int store_viewed;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date store_created;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date store_last_login;

    private int store_star;
    private int store_risk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private User store_user_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_password() {
        return store_password;
    }

    public void setStore_password(String store_password) {
        this.store_password = store_password;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_product() {
        return store_product;
    }

    public void setStore_product(String store_product) {
        this.store_product = store_product;
    }

    public String getStore_location() {
        return store_location;
    }

    public void setStore_location(String store_location) {
        this.store_location = store_location;
    }

    public String getStore_description() {
        return store_description;
    }

    public void setStore_description(String store_description) {
        this.store_description = store_description;
    }

    public String getStore_phone_number() {
        return store_phone_number;
    }

    public void setStore_phone_number(String store_phone_number) {
        this.store_phone_number = store_phone_number;
    }

    public String getStore_delivery() {
        return store_delivery;
    }

    public void setStore_delivery(String store_delivery) {
        this.store_delivery = store_delivery;
    }

    public String getStore_status() {
        return store_status;
    }

    public void setStore_status(String store_status) {
        this.store_status = store_status;
    }

    public int getStore_viewed() {
        return store_viewed;
    }

    public void setStore_viewed(int store_viewed) {
        this.store_viewed = store_viewed;
    }

    public Date getStore_created() {
        return store_created;
    }

    public void setStore_created(Date store_created) {
        this.store_created = store_created;
    }

    public Date getStore_last_login() {
        return store_last_login;
    }

    public void setStore_last_login(Date store_last_login) {
        this.store_last_login = store_last_login;
    }

    public int getStore_star() {
        return store_star;
    }

    public void setStore_star(int store_star) {
        this.store_star = store_star;
    }

    public int getStore_risk() {
        return store_risk;
    }

    public void setStore_risk(int store_risk) {
        this.store_risk = store_risk;
    }

    public User getStore_user_id() {
        return store_user_id;
    }

    public void setStore_user_id(User store_user_id) {
        this.store_user_id = store_user_id;
    }
}
