package com.gupao.example;

/**
 * Created by DJ on 2019年07月23日 19:49
 **/
public class ProductService implements IProductService {
    private ProductDao productDao;
    public ProductService(){
        this.productDao = new ProductDao();
    }
    @Override
    public int insertProduct(Product product) {
        System.out.println("ProductService调用ProductDao添加产品");
        return productDao.addProduct(product);
    }
}
