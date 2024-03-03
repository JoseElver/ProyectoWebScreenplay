package com.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConexionDB implements Interaction {

    public static String token;

    @Override
    public <T extends Actor> void performAs(T actor) {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(properties.getProperty("database.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String password = properties.getProperty("database.password");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String query = "SELECT * FROM test_db WHERE alias = 'Captcha'";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    token = resultSet.getString("alias");
                    System.out.println("ID: " + id + " alias " + token);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ConexionDB on(){

        return Tasks.instrumented(ConexionDB.class);
    }
}
