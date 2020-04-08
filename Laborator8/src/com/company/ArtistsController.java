package com.company;

import java.sql.*;

public class ArtistsController {

    private Database database;
    private Connection connection;

    public ArtistsController() throws SQLException {
        database = Database.getInstance();
        connection = database.getConnection();
    }

    ;

    public void create(String name, String country) throws SQLException {

            PreparedStatement st = connection.prepareStatement("INSERT INTO artists(name, country) Values(" +name +", "+country + ");");
            st.setObject (1,name);
            st.setObject(2,country);
            st.executeUpdate();
            st.close();
    }

    public void findByName(String name) throws SQLException {
            PreparedStatement st = connection.prepareStatement("SELECT name, country FROM artists WHERE name=" + name + ";");
            ResultSet result = st.executeQuery();

            while(result.next()) {
                System.out.print(result.getString(1) + " " + result.getString(2));
                System.out.println();
            }
    }
}