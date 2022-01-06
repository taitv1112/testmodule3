package dao;

import config.ConnectMySql;
import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    Connection connection = ConnectMySql.getConnection();
    public List<Product> getList() throws SQLException {
        String select = "SELECT product.*, category.name as categoryName FROM product join category on product.id_category = category.id";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int quantity = resultSet.getInt("quantity");
            int id_category = resultSet.getInt("id_category");
            String name= resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String description= resultSet.getString("description");
            String color= resultSet.getString("color");
            String name_category= resultSet.getString("categoryName");
            products.add(new Product( id,  name,  price,  quantity,  color,  description,  id_category,name_category));
        }
        return products;
    }
    public void insert(Product product) throws SQLException {
        String insert = "INSERT INTO product (name, price, quantity,description,color,id_category) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getDescription());
        preparedStatement.setString(5, product.getColor());
        preparedStatement.setInt(6, product.getId_category());
        preparedStatement.execute();
    }
    public void update(int id, Product product) throws SQLException {
        String update = "UPDATE product SET name = ?, price = ?, quantity = ?, description = ?, color = ?, id_category = ? WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getDescription());
        preparedStatement.setString(5, product.getColor());
        preparedStatement.setInt(6, product.getId_category());
        preparedStatement.setInt(7, id);
        preparedStatement.execute();
    }
    public void delete(int id) throws SQLException {
        String delete = "DELETE FROM product WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }
    public  List<Product> findByName(String nameFind) {
        String find = "SELECT product.*, category.name as categoryName FROM product join category on product.id_category = category.id" +
                "where product.name like '%"+nameFind+"%\'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(find);
            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int quantity = resultSet.getInt("quantity");
                int id_category = resultSet.getInt("id_category");
                String name= resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description= resultSet.getString("description");
                String color= resultSet.getString("color");
                products.add(new Product( id,  name,  price,  quantity,  color,  description,  id_category));
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
