import java.io.FileOutputStream;
import java.util.UUID;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;

public class ToXML 
{

    public static void run() throws Exception
    { 


        StartNode s = new StartNode(Types.NodeType(Types.NodeTypes.START), UUID.randomUUID());
        EndNode e = new EndNode(Types.NodeType(Types.NodeTypes.END), UUID.randomUUID());
        
        CircleNode c1 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE), UUID.randomUUID());
        CircleNode c2 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE), UUID.randomUUID());
        CircleNode c3 = new CircleNode(Types.NodeType(Types.NodeTypes.CIRCLE), UUID.randomUUID());

        s.setNextNode(c1.getNId());
        
        c1.setPreviousNode(s.getNId());
        c1.setNextNode(c2.getNId());
        c1.setPrintProperty("Circle 1");
        
        c2.setPreviousNode(c1.getNId());
        c2.setNextNode(c3.getNId());
        c2.setPrintProperty("Circle 2");
        
        c3.setPreviousNode(c2.getNId());
        c3.setNextNode(e.getNId());
        c3.setPrintProperty("Circle 3");

        e.setPreviousNode(c3.getNId());
        
        DBAction d1 = new DBAction(Types.NodeType(Types.NodeTypes.DB), UUID.randomUUID());

        d1.setConnectedNode(c2.getNId());
        c2.setConnectedAction(d1.getNId());
        

        NodeList nodeList = new NodeList();
        
        nodeList.addStartNode(s);

        nodeList.addCircleNode(c1);
        nodeList.addCircleNode(c2);
        nodeList.addCircleNode(c3);

        nodeList.addDBNode(d1);

        nodeList.addEndNode(e);
 
        JAXBContext contextObj = JAXBContext.newInstance(NodeList.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
  
      
        marshallerObj.marshal(nodeList, new FileOutputStream("./../nodes.xml"));  
    }  
}
