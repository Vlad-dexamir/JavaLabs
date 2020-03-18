package lab5;

public class MyCustomExceptions extends Throwable {

    public static String NoCatalogPath() {
        throw new Error("No Catalog path!");
    }


    public static String InvalidCatalogFile() {
        throw new Error("Invalid Catalog File!");
    }


    public static String InvalidCatalogName() {
        throw new Error("Invalid Catalog Name or Not Existing!");
    }
}
