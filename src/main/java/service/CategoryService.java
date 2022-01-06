package service;

import dao.CategoryDao;
import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();
    public List<Category> getList() throws SQLException {
        return categoryDao.getList();
    }
}
