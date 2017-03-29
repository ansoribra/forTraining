package com.qyubix.controller;

import com.qyubix.dao.ProductDao;
import com.qyubix.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductDao product;

    //GET METHOD========================================================================================================

    @CrossOrigin
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> getAllProduct(Pageable page){
        return product.findAll(page);
    }

    @CrossOrigin
    @RequestMapping(value = "/product", params = {"product_category","size","page"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> findByCategory(@RequestParam("product_category") String productCategory,
                                        @RequestParam("size") String size,
                                        @RequestParam("page") String page) {
        PageRequest reqpage = new PageRequest(Integer.parseInt(page),Integer.parseInt(size));
        return product.findByProductCategory(productCategory, reqpage);
    }

    @CrossOrigin
    @RequestMapping(value = "/product", params = "product_discount", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> findByDiscount(@RequestParam("product_discount") int productDiscount){
        PageRequest page = new PageRequest(0,5);
        return product.findByProductDiscount(productDiscount, page);
    }

    @CrossOrigin
    @RequestMapping(value = "/product", params = "product_discount_after", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> findByDiscountAfter(@RequestParam("product_discount_after") int productDiscountAfter){
        PageRequest page = new PageRequest(0,5);
        return product.findByProductDiscountAfter(productDiscountAfter, page);
    }

    @CrossOrigin
    @RequestMapping(value = "/product", params = "product_store_id", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> findByStoreId(@RequestParam("product_store_id") String productStoreId){
        PageRequest page = new PageRequest(0,5);
        return product.findByProductStoreId(productStoreId, page);
    }

    @RequestMapping(value = "/product", params = {"product_name","size","page"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Page<Product> findByName(@RequestParam("product_name") String productName,
                                    @RequestParam("size") String size,
                                    @RequestParam("page") String page){
        PageRequest reqpage = new PageRequest(Integer.parseInt(page),Integer.parseInt(size));
        return product.findByProductName(productName, reqpage);
    }

    @CrossOrigin
    @RequestMapping(value = "/product", params = "product_price", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> findByPrice(@RequestParam("product_price") int productPrice){
        PageRequest page = new PageRequest(0,5);
        return product.findByProductPrice(productPrice, page);
    }

    @RequestMapping(value = "/product", params = "product_rating", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK) @CrossOrigin
    public Page<Product> findByRating(@RequestParam("product_rating") int productRating){
        PageRequest page = new PageRequest(0,5);
        return product.findByProductRating(productRating, page);
    }

    @RequestMapping(value = "/product", params = "product_sold", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK) @CrossOrigin
    public Page<Product> findBySold(@RequestParam("product_sold") int productSold){
        PageRequest page = new PageRequest(0,5);
            return product.findByProductSold(productSold, page);
    }

    @RequestMapping(value = "/product", params = "product_description", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK) @CrossOrigin
    public Page<Product> findByDescription(@RequestParam("product_description") String productDescription){
        PageRequest page = new PageRequest(0,5);
        return product.findByProductDescription(productDescription, page);
    }

    @RequestMapping(value = "/product", params = "product_image_total", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Page<Product> findByImageTotal(@RequestParam("product_image_total") int productImageTotal){
        PageRequest page = new PageRequest(0,5);
        return product.findByProductImageTotal(productImageTotal, page);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<Product> findById(@PathVariable("id") String id){
        Product idResult = product.findOne(id);
        if(idResult==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idResult,HttpStatus.OK);
    }

    //POST METHOD=======================================================================================================
        @RequestMapping(value = "/product", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        public void insertNewProduct(@RequestBody Product p){
            product.save(p);
        }

    //PUT METHOD========================================================================================================
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable("id") String id,@RequestBody Product p){
        p.setId(id);
        product.save(p);
    }

    //DELETE METHOD=====================================================================================================
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") String id){
        product.delete(id);
    }
}
