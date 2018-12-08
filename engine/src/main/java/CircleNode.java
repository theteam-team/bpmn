import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
class CircleNode extends Node
{

    private UUID previousNode = null;
    private UUID nextNode = null;

    private String printProperty = null;

    public CircleNode()
    {

    }

    public CircleNode(String type)
    {
        this.type = type;
    }

    @XmlAttribute
    public String getId()
    {
        return id.toString();  
    }

    @XmlAttribute
    public String getType()
    {
        return type;  
    }  

    public void setType(String type)
    {  
        this.type = type;  
    }

    @XmlElement(name = "previousNode")
    public String getPreviousNode()
    {

        if(previousNode != null)
            return previousNode.toString();
        return "empty";
        
    }

    /*public void setPreviousNode(UUID previousNode) {
        this.previousNode = previousNode;
    }*/

    @XmlElement(name = "nextNode")
    public String getNextNode()
    {

        if(nextNode != null)
            return nextNode.toString();
        return "empty";
    }

    /*public void setNextNode(UUID nextNode) {
        this.nextNode = nextNode;
    }*/

    @XmlElement(name = "printProperty")
    public String getPrintProperty()
    {

        if(printProperty != null)
            return printProperty;
        return "empty";
        
    }

    /*public void setPrintProperty(String printProperty) {
        this.printProperty = printProperty;
    }*/

    @Override
    void run()
    {
        System.out.println(getId() + " " + getType());
    }

}
