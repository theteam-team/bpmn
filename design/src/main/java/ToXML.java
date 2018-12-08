import java.io.FileOutputStream;  
import java.util.*;
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;

public class ToXML {    

    public static void run() throws Exception{ 

        CircleNode c1 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE));
        
        CircleNode c2 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE));
        
        CircleNode c3 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE));

        CircleNodeList li = new CircleNodeList();
        li.setList(new ArrayList<CircleNode>());

        li.getList().add(c1);
        li.getList().add(c2);
        li.getList().add(c3);
 
        JAXBContext contextObj = JAXBContext.newInstance(CircleNodeList.class);  
        Marshaller marshallerObj = contextObj.createMarshaller();  
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
  
      
        marshallerObj.marshal(li, new FileOutputStream("./../nodes.xml"));  
    }  
}
