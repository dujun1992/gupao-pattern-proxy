package com.gupao.example;

import com.gupao.myproxy.ProductServiceMyProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DJ on 2019年07月23日 19:46
 **/
public class Test {
    public static void main(String[] args) {
        Product p = new Product();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse("2018/01/01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p.setAdd_time(date.getTime());
        //静态代理
        //IProductService ip = new ProductServiceStaticProxy(new ProductService());

        //JDK代理
        //IProductService ip = (IProductService)new ProductServiceJdkProxy().getInstance(new ProductService());

        //CGLib代理
        //ProductService ip = (ProductService)new ProductServiceCGLibProxy().getInstance(ProductService.class);

        //自己创建
        IProductService ip = (IProductService)new ProductServiceMyProxy().getInstance(new ProductService());
        ip.insertProduct(p);

    }
}
