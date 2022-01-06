package service;

import dao.ProductDao;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDao();
    public List<Product> getList() throws SQLException {
        return productDao.getList();
    }
    public void save(Product product) throws SQLException {
        productDao.insert(product);
        getList();
    }
    public void edit(int id,Product product) throws SQLException {
        productDao.update(id,product);
        getList();
    }
    public void delete(int id) throws SQLException {
        productDao.delete(id);
        getList();
    }
    public List<Product> findProductByName(String name) throws SQLException {
        return productDao.findByName(name);
    }
    public Product getProductById(int id) throws SQLException {
        for (int i = 0; i < productDao.getList().size(); i++) {
            if(id==productDao.getList().get(i).getId()){
                return productDao.getList().get(i);
            }
        }
        return null;
    }
}
