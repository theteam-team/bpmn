import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CircleNodeList {

    @XmlElement
    private List<CircleNode> l;

    public void setList(List<CircleNode> l) {
        this.l = l;
    }

    public List<CircleNode> getList() {
        return l;
    }
}
