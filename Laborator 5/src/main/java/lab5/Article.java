package lab5;

import java.util.List;

public class Article extends Document {
    public Article(String name, String id, List<TagType> additionalTags, String location) {
        super(name, id, additionalTags, location);
    }

}
