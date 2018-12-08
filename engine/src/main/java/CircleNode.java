import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
class CircleNode extends Node{

    public CircleNode() {
    }

    public CircleNode(String type) {
        this.type = type;
    }

    @XmlAttribute
    public String getId() {
        return id.toString();  
    }

    @XmlAttribute
    public String getType(){
        return type;  
    }  

    public void setType(String type) {  
        this.type = type;  
    }

    @Override
    void run()
    {
        System.out.println(getId() + " " + getType());
    }

}
