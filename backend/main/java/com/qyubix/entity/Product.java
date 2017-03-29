package com.qyubix.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    private String product_store_id;

    @NotNull
    private String product_name;

    @NotNull
    private String product_category;

    @NotNull
    private int product_price;

    private int product_image_total;

    @Lob
    @Column(length=10000)
    private String product_description;
    private int product_sold;
    private int product_rating;
    private int product_discount;
    private int product_discount_after;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_store_id() {
        return product_store_id;
    }

    public void setProduct_store_id(String product_store_id) {
        this.product_store_id = product_store_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getProduct_sold() {
        return product_sold;
    }

    public void setProduct_sold(int product_sold) {
        this.product_sold = product_sold;
    }

    public int getProduct_rating() {
        return product_rating;
    }

    public void setProduct_rating(int product_rating) {
        this.product_rating = product_rating;
    }

    public int getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(int product_discount) {
        this.product_discount = product_discount;
    }

    public int getProduct_discount_after() {
        return product_discount_after;
    }

    public void setProduct_discount_after(int product_discount_after) {
        this.product_discount_after = product_discount_after;
    }

    public int getProduct_image_total() {
        return product_image_total;
    }

    public void setProduct_image_total(int product_image_total) {
        this.product_image_total = product_image_total;
    }
}
