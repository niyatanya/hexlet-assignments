package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String tagBody;
    List<Tag> children;

    public PairedTag(String name,
                     Map<String, String> attributes,
                     String tagBody,
                     List<Tag> children
    ) {
        super(name, attributes);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        String parentTag = new SingleTag(this.name, this.attributes).toString();
        String childTags = this.children.stream()
                                        .map(e -> new SingleTag(e.getName(), e.getAttributes()))
                                        .map(SingleTag::toString)
                                        .reduce("", String::concat);
        return parentTag + childTags + this.tagBody + "</" + this.name + ">";
    }
}
// END
