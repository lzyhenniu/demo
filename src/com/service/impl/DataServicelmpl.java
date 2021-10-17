package com.service.impl;

import com.pojo.Product;

import java.util.HashMap;

public class DataServicelmpl {


    public static HashMap<Integer,Product>getAll(){
        HashMap<Integer,Product> products =new HashMap<>();
     Product product;
     int[] ids={1924,1343,1231,3245,3246,7654};
    String[] names={"name1","name2","name3","name4","name5","name6"};
    String[] deses={"deses1","deses2","deses3","deses4","deses5","deses6"};
    String[] images={"xh_img1.jpg","xh_img2.jpg","xh_img3.jpg","xh_img4.jpg","xh_img5.jpg","xh_img6.jpg"};

    double[] prices={433.32,332.56,65.78,45.00,34.00,453.00};
    int[] stockes={343,244,44,322,67,45};
    for (int i=0;i<6;i++){
        product=new Product();
        product.setId(ids[i]);
        product.setName(names[i]);
    product.setImgUrl(images[i]);
  product.setNum(stockes[i]);
     product.setPrice(prices[i]);
     product.setDesc(deses[i]);
     products.put(product.getId(),product);

    }
return products;
    }
public static Product findById(int id){
        return getAll().get(id);
}

}
