package com.example.shoppingcartv2;

import java.sql.*;
import java.util.List;

public class DBConnection {
    private Connection connection;
    DBConnection() {
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/products",
                    "root", "");
            if (connection != null) {
                System.out.println("Success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getData( List<ItemBean> itemBeanShop) {

        try {
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from items");
            int quantity, price;
            String name,url;
            while (resultSet.next()) {
                quantity= resultSet.getInt("Quantity");
                price= resultSet.getInt("Price");
                name= resultSet.getString("Name").trim();
                url= resultSet.getString("ImageUrl");

                ItemBean item = new ItemBean(name, quantity, price, url);
                itemBeanShop.add(item);

            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void updateData( String name, int quantity) {

        try {
            String query = "update items set Quantity = ? where Name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt   (1, quantity);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void signUp(String name, String password)
    {
        try {
            String query = "insert into users (Name, Password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void getLoginData(String name){
        try {
            ResultSet resultSet;
            String query = "select * from users where Name = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);

            resultSet=preparedStatement.executeQuery(query);
            preparedStatement.close();
            resultSet.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

}
