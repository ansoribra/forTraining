package com.qyubix.datainjector.filesys;

import com.qyubix.dao.ProductDao;
import com.qyubix.dao.StoreDao;
import com.qyubix.entity.Product;
import com.qyubix.entity.Store;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

@RestController
public class InjectFolder {

    @Autowired
    private StoreDao store;

    @Autowired
    private ProductDao product;

    @Autowired
    private DataSource ds;

    private static final Logger log = LoggerFactory.getLogger(InjectFolder.class);
    public static final String images = System.getProperty("user.dir")+"/images";
    public static final String fakeimages = System.getProperty("user.dir")+"/fakeimages";

    Random random = new Random();

    @CrossOrigin
    @RequestMapping(value = "/createfolder",method = RequestMethod.GET)
    public String createFolder() throws IOException {
        System.out.println(images);
        FileUtils.cleanDirectory(new File(images));

        for (Store model:store.findAll()) {
            System.out.println(model.getStore_id());
            Path path = Paths.get(images+"/"+model.getStore_id());
            Files.createDirectories(path);
        }
        return "Success create folder";
    }

    @CrossOrigin
    @RequestMapping(value = "/uploadimage",method = RequestMethod.GET)
    public String uploadImage() throws IOException, SQLException {
        for (Product model:product.findAll()) {
            String mId       = model.getId();
            String mStoreId  = model.getProduct_store_id();
            int mImageTotal = model.getProduct_image_total();
            String queryGetStoreProduct = " select store_product from store where store_id = ?";
            String mCategory;

            Path path = Paths.get(images+"/"+mStoreId+"/"+mId);
            Files.createDirectories(path);
            try(Connection c = ds.getConnection()){
                PreparedStatement ps = c.prepareStatement(queryGetStoreProduct);
                ps.setString(1,mStoreId);
                ResultSet rs = ps.executeQuery();
                rs.next();
                mCategory = rs.getString("store_product");
            }

            for(int i = 1; i<=mImageTotal;i++) {
                System.out.println("ID : " + mId +
                        "\nCategory : " + mCategory +
                        "\nProduct store ID : " + mStoreId);

                File resource = new File(fakeimages + "/" + mCategory.replaceAll("\\W.*", "") + "/" + (random.nextInt(5) + 1) + ".jpg");
                File destination = new File(images + "/" + mStoreId + "/" + mId + "/"+i+".jpg");
                System.out.println("Resource : " + resource.getAbsoluteFile() + "\nDestination : " + destination.getAbsoluteFile());

                if (!resource.exists()) {
                    resource = new File(fakeimages + "/sport/" + (random.nextInt(5) + 1) + ".jpg");
                }
                Files.copy(resource.toPath(), destination.toPath());
            }
        }
        return "Success upload images";
    }
}