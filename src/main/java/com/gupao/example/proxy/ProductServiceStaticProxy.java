package com.gupao.example.proxy;

import com.gupao.example.IProductService;
import com.gupao.example.Product;
import com.gupao.example.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DJ on 2019年07月23日 19:37
 **/
public class ProductServiceStaticProxy implements IProductService {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private  IProductService productService;
    public ProductServiceStaticProxy(IProductService productService){
        this.productService = productService;
    }
    @Override
    public int insertProduct(Product product) {
        Long time = product.getAdd_time();
        Integer dbRouter = Integer.parseInt(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        DynamicDataSourceEntity.set(dbRouter);

        this.productService.insertProduct(product);

        DynamicDataSourceEntity.restore();
        return 1;
    }
}
