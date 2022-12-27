package com.codegym.demo.dao;

import com.codegym.demo.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "Select * from product";
        Connection connection = ConnectionMySql.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                products.add(new Product(id, name, img, true, price));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public static boolean save(Product product) {
        String sql = "insert into product value (?,?,?,?)";
                Connection connection = ConnectionMySql.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(4, product.getImg());
            preparedStatement.setDouble(3, product.getPrice());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean edit(Product product) {
        String sql = "update product set name=?, img=?, price=? where id=?";
        Connection connection = ConnectionMySql.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(4,product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setDouble(3, product.getPrice());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Product findById(int id){
        String sql = "select * from product where id = "+ id;
        Connection connection = ConnectionMySql.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            String name = resultSet.getString("name");
            String img = resultSet.getString("img");
            double price = resultSet.getDouble("price");

            return new Product(id, name,img, true, price);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void delete(int id){
        String sql ="delete FROM product where id = "+id;
        Connection connection = ConnectionMySql.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
