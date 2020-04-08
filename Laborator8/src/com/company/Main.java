package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
	ArtistsController artistsController = new ArtistsController();

	artistsController.create("Artist1", "Country1");
	artistsController.create("Artist2", "Artist2");

	artistsController.findByName("Artist1");

	AlbumController albumController = new AlbumController();
	albumController.create("Album1", 1, 2000);
	albumController.create("Album2", 2, 2000);

	albumController.findByName(2);
    }
}
