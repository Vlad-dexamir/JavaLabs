package lab5;

import java.util.List;

public class Book extends Document {
    public Book(String name, String id, List<TagType> additionalTags, String location) {
        super(name, id, additionalTags, location);
    }
}
