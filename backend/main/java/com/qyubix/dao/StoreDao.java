package com.qyubix.dao;

import com.qyubix.entity.Store;
import com.qyubix.entity.Product;
import com.qyubix.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface StoreDao extends PagingAndSortingRepository<Store,String> {

    @Query("select x from Store x where x.store_created = :a")
    public Page<Store> findByStoreCreated(@Param("a") Date storeCreated, Pageable page);

    @Query("select x from Store x where extract(year from x.store_created) = :a")
    public Page<Store> findByStoreCreatedYear (@Param("a")  int  year, Pageable page);

    @Query("select x from Store x where extract(month from x.store_created) = :a")
    public Page<Store> findByStoreCreatedMonth (@Param("a")  int  month, Pageable page);

    @Query("select x from Store x where extract(day from x.store_created) = :a")
    public Page<Store> findByStoreCreatedDay (@Param("a")  int  day, Pageable page);

    @Query("select x from Store x where x.store_delivery like %:a%")
    public Page<Store> findByStoreDelivery(@Param("a") String storeDelivery, Pageable page);

    @Query("select x from Store x where x.store_description like %:a%")
    public Page<Store> findByStoreDescription(@Param("a") String storeDescription, Pageable page);

    @Query("select x from Store x where x.store_id like %:a%")
    public Page<Store> findByStoreId(@Param("a") String storeId, Pageable page);

    @Query("select x from Store x where x.store_last_login = :a")
    public Page<Store> findByStoreLastLogin(@Param("a") Date storeLastLogin, Pageable page);

    @Query("select x from Store x where x.store_location like %:a%")
    public Page<Store> findByStoreLocation(@Param("a") String storeLocation, Pageable page);

    @Query("select x from Store x where x.store_name like %:a%")
    public Page<Store> findByStoreName(@Param("a") String storeName, Pageable page);

    @Query("select x from Store x where x.store_phone_number = :a")
    public Page<Store> findByStorePhoneNumber(@Param("a") String storePhoneNumber, Pageable page);

    @Query("select x from Store x where x.store_product like %:a%")
    public Page<Store> findByStoreProduct(@Param("a") String storeProduct, Pageable page);

    @Query("select x from Store x where x.store_risk = :a")
    public Page<Store> findByStoreRisk(@Param("a") int storeRisk, Pageable page);

    @Query("select x from Store x where x.store_star = :a")
    public Page<Store> findByStoreStar(@Param("a") int storeStar, Pageable page);

    @Query("select x from Store x where x.store_status = :a")
    public Page<Store> findByStoreStatus(@Param("a") String storeStatus, Pageable page);

    @Query("select x from Store x where x.store_viewed = :a")
    public Page<Store> findByStoreViewed(@Param("a") int storeViewed, Pageable page);

    @Query("select x from Store x where x.store_id = :a")
    public Store getStoreProductByStoreId(@Param("a") int storeId);
}
