package dao;

import config.ConnectMySql;
import model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    Connection connection = ConnectMySql.getConnection();
    public List<Category> getList() throws SQLException {
        String select = "select * from category";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Category> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            list.add(new Category(id, name));
        }
        return list;
    }
}
