import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "nodes")
@XmlType(propOrder = { "startNode", "dbNodes", "circleNodes", "endNode"})
public class XNodeList
{
    @XmlElement(name = "startNode")
    private XStartNode startNode;

    @XmlElement(name = "endNode")
    private XEndNode endNode;

    @XmlElement(name = "circleNode")
    private List<XCircleNode> circleNodes;

    @XmlElement(name = "dbNode")
    private List<XDBAction> dbNodes;
    

    public XNodeList ()
    {
        circleNodes = new ArrayList<XCircleNode>();
        dbNodes = new ArrayList<XDBAction>();
    }

    public List<XNode> getAllNodes()
    {
        List<XNode> allNodes = new ArrayList<XNode>();

        allNodes.add(startNode);
        
        for(XCircleNode node : circleNodes)
        {
            allNodes.add(node);
            
        }

        allNodes.add(endNode);

        return allNodes;
    }

    public void setCircleNodes(List<XCircleNode> circleNodes) {
        this.circleNodes = circleNodes;
    }
    
    public List<XCircleNode> getCircleList()
    {
        return circleNodes;
    }
    
    public void addCircleNode(XCircleNode node)
    {
        circleNodes.add(node);
    }

    public List<XDBAction> getDBList()
    {
        return dbNodes;
    }

    public void addDBNode(XDBAction node)
    {
        dbNodes.add(node);
    }

    public void addStartNode(XStartNode node)
    {
        startNode = node;
    }

    public XNode getStartNode()
    {
        return startNode;
    }
    
    public void addEndNode(XEndNode node)
    {
        
        endNode = node;
    }
}
