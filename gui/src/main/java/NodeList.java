import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "nodes")
@XmlType(propOrder = { "startNode", "dbNodes", "circleNodes", "endNode"})
public class NodeList
{
    @XmlElement(name = "startNode")
    private StartNode startNode;

    @XmlElement(name = "endNode")
    private EndNode endNode;

    @XmlElement(name = "circleNode")
    private List<CircleNode> circleNodes;

    @XmlElement(name = "dbNode")
    private List<DBAction> dbNodes;
    

    public NodeList ()
    {
        circleNodes = new ArrayList<CircleNode>();
        dbNodes = new ArrayList<DBAction>();
    }

    public List<Nodes> getAllNodes()
    {
        List<Nodes> allNodes = new ArrayList<Nodes>();

        allNodes.add(startNode);
        
        for(CircleNode node : circleNodes)
        {
            allNodes.add(node);
            
        }

        allNodes.add(endNode);

        return allNodes;
    }

    public void setCircleNodes(List<CircleNode> circleNodes) {
        this.circleNodes = circleNodes;
    }
    
    public List<CircleNode> getCircleList()
    {
        return circleNodes;
    }
    
    public void addCircleNode(CircleNode node)
    {
        circleNodes.add(node);
    }

    public List<DBAction> getDBList()
    {
        return dbNodes;
    }

    public void addDBNode(DBAction node)
    {
        dbNodes.add(node);
    }

    public void addStartNode(StartNode node)
    {
        startNode = node;
    }

    public Nodes getStartNode()
    {
        return startNode;
    }
    
    public void addEndNode(EndNode node)
    {
        
        endNode = node;
    }
}
