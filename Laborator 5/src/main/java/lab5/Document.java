package lab5;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class Document implements Serializable {
    private String name;
    private String id;
    private List<TagType> additionalTags;
    private String location;

    public Document( String name, String id, List<TagType> additionalTags, String location) {
        this.name = name;
        this.id = id;
        this.additionalTags = additionalTags;
        this.location = location;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAdditionalTags(List<TagType> additionalTags) {
        this.additionalTags = additionalTags;
    }

    public List<TagType> getAdditionalTags() {
        return additionalTags;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
