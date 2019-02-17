package com.example.th.sorm;

import com.sun.media.sound.SoftTuning;

import java.sql.*;

public class DBdriver {
    public static void main(String[] args) {

        try {
            Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/estore", "root", "123");

            Statement statement = connection.createStatement();

            String sql = "select * from cart";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }



        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
