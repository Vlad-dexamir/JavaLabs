package lab5;

import java.awt.*;
import java.io.*;
import java.net.URI;

import static java.awt.Desktop.getDesktop;

public class ExternalOperations {

    public static void Save(Catalog catalog) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(catalog.getPath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(catalog);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Catalog Load(String path) {
        if (path.equals(null) || path.equals("")) {
            MyCustomExceptions.NoCatalogPath();
        }

        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Catalog catalog = (Catalog) objectInputStream.readObject();

            if(catalog.getName().equals(null) || catalog.getName().equals("")) {
                MyCustomExceptions.InvalidCatalogName();
            }

            return catalog;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            MyCustomExceptions.InvalidCatalogFile();
        }

        return null;
    }

    public static void View(Document document) throws IOException {
        File file = new File(document.getLocation());
        Desktop desktop;
        getDesktop().browse(URI.create(document.getLocation()));
        getDesktop().open(file);
    }
}
