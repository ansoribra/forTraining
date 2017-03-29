package com.qyubix.controller;

import com.qyubix.dao.StoreDao;
import com.qyubix.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class StoreController {

    @Autowired
    private StoreDao store;

    //GET METHOD========================================================================================================
    @RequestMapping("/store")
    public Page<Store> getAllProduct(Pageable page){
        return store.findAll(page);
    }

    @RequestMapping(value = "/storep", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByCreated(@RequestParam(value = "store_created", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date storeCreated,
                                  @RequestParam(value = "day", defaultValue = "0") int day,
                                  @RequestParam(value = "month", defaultValue = "0") int month,
                                  @RequestParam(value = "year", defaultValue = "0") int year) {
        PageRequest page = new PageRequest(0, 5);
        if (day!=0){
            return store.findByStoreCreatedDay(day, page);
        }else if (month!=0){
            return store.findByStoreCreatedMonth(month, page);
        }else if (year!=0){
            return store.findByStoreCreatedYear(year, page);
        }else{
            return store.findByStoreCreated(storeCreated, page);
        }
    }

    @RequestMapping(value = "/store", params = "store_delivery", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findBydelivery(@RequestParam("store_delivery") String storeDelivery){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreDelivery(storeDelivery, page);
    }

    @RequestMapping(value = "/store", params = "store_description", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByDescription(@RequestParam("store_description") String storeDescription){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreDescription(storeDescription, page);
    }

    @RequestMapping(value = "/store", params = "store_id", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findById(@RequestParam("store_id") String storeId){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreId(storeId, page);
    }

    @RequestMapping(value = "/store", params = "store_last_login", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByLastLogin(@RequestParam("store_last_login") @DateTimeFormat(pattern="yyyy-MM-dd") Date storeLastLogin){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreLastLogin(storeLastLogin, page);
    }

    @RequestMapping(value = "/store", params = "store_location", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByLocation(@RequestParam("store_location") String storeLocation){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreLocation(storeLocation, page);
    }

    @RequestMapping(value = "/store", params = "store_name", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByName(@RequestParam("store_name") String storeName){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreName(storeName, page);
    }

    @RequestMapping(value = "/store", params = "store_phone_number", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByPhoneNumber(@RequestParam("store_phone_number") String storePhoneNumber){
        PageRequest page = new PageRequest(0,5);
        return store.findByStorePhoneNumber(storePhoneNumber, page);
    }

    @RequestMapping(value = "/store", params = "store_product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByProduct(@RequestParam("store_product") String storeProduct){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreProduct(storeProduct, page);
    }

    @RequestMapping(value = "/store", params = "store_risk", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByRisk(@RequestParam("store_risk") int storeRisk){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreRisk(storeRisk, page);
    }

    @RequestMapping(value = "/store", params = "store_star", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByStar(@RequestParam("store_star") int storeStar){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreStar(storeStar, page);
    }

    @RequestMapping(value = "/store", params = "store_status", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByStatus(@RequestParam("store_status") String storeStatus){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreStatus(storeStatus, page);
    }

    @RequestMapping(value = "/store", params = "store_viewed", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Store> findByViewed(@RequestParam("store_viewed") int storeViewed){
        PageRequest page = new PageRequest(0,5);
        return store.findByStoreViewed(storeViewed, page);
    }


    //POST METHOD=======================================================================================================
    //PUT METHOD========================================================================================================
    //DELETE METHOD=====================================================================================================

}
