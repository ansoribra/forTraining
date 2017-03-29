package com.qyubix.dao;

import com.qyubix.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDao extends PagingAndSortingRepository<Product,String> {

    @Query("select x from Product x where x.product_category like %:a%")
    public Page<Product> findByProductCategory(@Param("a") String productCategory, Pageable page);

    @Query("select x from Product x where x.product_description like %:a%")
    public Page<Product> findByProductDescription(@Param("a") String productDescription, Pageable page);

    @Query("select x from Product x where x.product_discount = :a")
    public Page<Product> findByProductDiscount(@Param("a") int productDiscount, Pageable page);

    @Query("select x from Product x where x.product_discount_after = :a")
    public Page<Product> findByProductDiscountAfter(@Param("a") int productDiscountAfter, Pageable page);

    @Query("select x from Product x where x.product_store_id like %:a%")
    public Page<Product> findByProductStoreId(@Param("a") String productstoreId, Pageable page);

    @Query("select x from Product x where x.product_name like %:a%")
    public Page<Product> findByProductName(@Param("a") String productName, Pageable page);

    @Query("select x from Product x where x.product_price = :a")
    public Page<Product> findByProductPrice(@Param("a") int productPrice, Pageable page);

    @Query("select x from Product x where x.product_rating = :a")
    public Page<Product> findByProductRating(@Param("a") int productRating, Pageable page);

    @Query("select x from Product x where x.product_sold = :a")
    public Page<Product> findByProductSold(@Param("a") int productSold, Pageable page);


    @Query("select x from Product x where x.product_image_total = :a")
    public Page<Product> findByProductImageTotal(@Param("a") int productImageTotal, Pageable page);
}
