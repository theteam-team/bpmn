
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
class DBNode extends Node{

    public DBNode() {

    }

    public DBNode(String type) {

        this.type = type;
    }

    @XmlAttribute
    public String getId() {
        return id.toString();  
    }

    @XmlAttribute
    public String getType() {
        return type;  
    }

    public void setType(String type) {  
        this.type = type;  
    }

    @Override
    void run()
    {

    }

}
