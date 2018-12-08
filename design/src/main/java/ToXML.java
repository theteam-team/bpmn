import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;

public class ToXML 
{

    public static void run() throws Exception
    { 
        CircleNode c1 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE));
        CircleNode c2 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE));
        CircleNode c3 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE));

        CircleNodeList nodeList = new CircleNodeList();
        
        nodeList.addNode(c1);
        nodeList.addNode(c2);
        nodeList.addNode(c3);
 
        JAXBContext contextObj = JAXBContext.newInstance(CircleNodeList.class);  
        Marshaller marshallerObj = contextObj.createMarshaller();  
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
  
      
        marshallerObj.marshal(nodeList, new FileOutputStream("./../nodes.xml"));  
    }  
}
