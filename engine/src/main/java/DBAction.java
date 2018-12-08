import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = { "connectedNode", "nameProperty" })
class DBAction extends Action
{

    private String connectedNode = null;

    private String nameProperty = null;

    public DBAction() {

    }

    public DBAction(String type, UUID id)
    {

        this.type = type;
        this.id = id.toString();

        this.uuid = id;
    }

    @XmlAttribute
    public String getId()
    {
        return id.toString();  
    }

    
    public void setId(String id)
    {
        this.id = id;
    }

    public UUID getUUId()
    {
        return uuid;  
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

    @XmlElement(name = "connectedNode")
    public String getConnectedNode()
    {

        if(connectedNode != null)
            return connectedNode.toString();
        return null;
    }

    public void setConnectedNode(String connectedNode) {
        this.connectedNode = connectedNode;
    }

    @XmlElement(name = "nameProperty")
    public String getNameProperty()
    {

        if(nameProperty != null)
            return nameProperty;
        return null;
        
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty = nameProperty;
    }

    @Override
    void run()
    {

    }

}
