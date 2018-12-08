import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
class CircleNode {
    private int id;

    public CircleNode() {}

    public CircleNode(int id) {
        this.id = id;
    }

    @XmlAttribute  
    public int getId() {  
        return id;  
    }  
    
    public void setId(int id) {  
        this.id = id;  
    }

}
