import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nodes")
public class CircleNodeList
{

    @XmlElement(name = "node")
    private List<CircleNode> nodes;

    public CircleNodeList ()
    {
        nodes = new ArrayList<CircleNode>();
    }

    public List<CircleNode> getList()
    {
        return nodes;
    }

    public void addNode(CircleNode node)
    {
        nodes.add(node);
    }
}
