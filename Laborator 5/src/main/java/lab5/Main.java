package lab5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        final String path = "/Users/vlad.dexamir/Documents/FacultateSem2 Labs/Java/Laborator 5/Catalog.ser";
        Catalog catalog = new Catalog("Catalog.ser", path);
        ExternalOperations.Save(catalog);
        Catalog newCatalog = ExternalOperations.Load(path);

        System.out.println(newCatalog.getName());
        System.out.println(newCatalog.getElements());

        //ExternalOperations.View(catalog.getElements().get(0));
    }
}
