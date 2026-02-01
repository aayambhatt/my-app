package com.example.my_app.jdbc;

import com.example.my_app.model.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MyJDBC {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/mydb";
        String dbUser = "myuser";
        String dbPassword = "mypassword";

        // Make the connection with DB
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            updateItem(new Item(2, "Lakme Nailpaint", 280D), connection);
            System.out.println("Connected successfully");
        } catch (SQLException exception) {
            exception.getStackTrace();
            System.out.println("Connection failed");
        } finally {
            if (connection != null) {
                connection.close();
                addItem(new Item(3, "Shoes", 4000D), connection);
            }
        }
    }

    public static Item addItem(Item item, Connection connection) throws SQLException {
//        Statement statement = connection.createStatement();
//        statement.execute("INSERT INTO items VALUES ("
//                + item.getId() + ", '" + item.getName() + "', " + item.getPrice() + ")");
//        return item;

        PreparedStatement ps = connection.prepareStatement("INSERT INTO items VALUES(?, ?, ?)");
        ps.setInt(1, item.getId());
        ps.setString(2, item.getName());
        ps.setDouble(3,item.getPrice());

        ps.execute();

        return item;
    }

    // This method reads all items from the database and returns them as a List
    public static List<Item> readItemsFromDB(Connection connection) throws SQLException {

        // Create a PreparedStatement to execute the SQL query
        // This query selects all records from the "items" table
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM items");

        // Execute the query and store the result in a ResultSet
        // Result Set holds the data returned from the database
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to store Item objects fetched from the database
        List<Item> itemList = new ArrayList<>();

        // Loop through each row in the ResultSet
        while (resultSet.next()) {

            // Create a new Item object using data from the current row
            // "id", "name", and "price" are column names in the database table
            Item item = new Item(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price")
            );

            // Add the Item object to the list
            itemList.add(item);
        }

        // Return the list containing all items from the database
        return itemList;
    }


    public static Item updateItem(Item item, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        // Update method following the same style as addItem
        statement.execute("UPDATE items SET name = '" + item.getName()
                + "', price = " + item.getPrice()
                + " WHERE id = " + item.getId());
        return item;
    }
}