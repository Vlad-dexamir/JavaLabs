package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumController {

    private Database database;
    private Connection connection;

    public AlbumController() throws SQLException {
        database = Database.getInstance();
        connection = database.getConnection();
    }

    ;

    public void create(String name, int artistId, int releaseYear) throws SQLException {

        PreparedStatement st = connection.prepareStatement("INSERT INTO albums(name, artist_id, release_year) Values(" +name +", "+artistId + "," + releaseYear +");");
        st.setObject (1,name);
        st.setObject(2,artistId);
        st.setObject(3,releaseYear);
        st.executeUpdate();
        st.close();
    }

    public void findByName(int artistId) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT name, artis_id, release_year FROM artists WHERE artist_id=" + artistId + ";");
        ResultSet result = st.executeQuery();

        while(result.next()) {
            System.out.print(result.getString(1) + " " + result.getInt(2) + " " + result.getInt(3));
            System.out.println();
        };
    }
}

