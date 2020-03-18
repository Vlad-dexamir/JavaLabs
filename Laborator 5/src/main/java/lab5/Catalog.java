package lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> elements;

    public Catalog(String name, String path,List<Document> elements) {
        this.name = name;
        this.path = path;
        this.elements = elements;
    }

    public Catalog(String name, String path) {
        TagType additionalTag1 = new TagType("title", "Learn Java");
        TagType additionalTag2 = new TagType("author", "John K");
        TagType additionalTag3 = new TagType("year", "2019");

        List<TagType> additionalTags = new ArrayList<TagType>();
        additionalTags.add(additionalTag1);
        additionalTags.add(additionalTag2);
        additionalTags.add(additionalTag3);

        Article article = new Article("Articol1", "idArt", additionalTags, "https://docs.google.com/document/d/1C4bfjYx5AI7W2tq-dLJywxftW1d1fCoMta1AsLJI0eE/edit");

        Book book = new Book("Book1", "idBoo", additionalTags, "/Users/vlad.dexamir/Documents/Prezentare React FiiPractic.pdf");

        Dvd dvd = new Dvd("Dvd1", "idDvd", additionalTags,"/Users/vlad.dexamir/Downloads/Captions off test.mov" );

        List<Document> elements = new ArrayList<Document>();
        elements.add(article);
        elements.add(book);
        elements.add(dvd);

        this.name = name;
        this.path = path;
        this.elements = elements;
    }

    public List<Document> getElements() {
        return elements;
    }

    public void setElements(List<Document> elements) {
        this.elements = elements;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Document findElementsByName(String name) {
        /**
         * FUNCTIONAL PROGRAMMING IS THE BEST!!!
         */
        return elements.stream().filter(document -> document.getName().equals(name)).findFirst().orElse(null);
    }

    public Document findElementsById(String id) {
        return elements.stream().filter(document -> document.getId().equals(id)).findFirst().orElse(null);
    }
}
