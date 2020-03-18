package lab5;

import java.io.Serializable;

public class TagType implements Serializable {
   public String name;
   public String value;

    public TagType(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
