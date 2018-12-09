import java.io.File;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;

public class ToJava {  

    static NodeList nodes;

    public static void run() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(NodeList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
     
        nodes = (NodeList) jaxbUnmarshaller.unmarshal( new File("./../nodes.xml") );
     
        System.out.println("\n Nodes in the design");

        for(Node node : nodes.getAllNodes())
        {
            System.out.println(node.getNId() + " " + node.getType());
        }

        System.out.println("\n Execute Circle Tasks");
        
        Node n = nodes.getStartNode();

        while(n.getNextNode() != null)
        {
            n = getNodeFromID(n.getNextNode());

            if(n == null)
            {
                System.out.println("ID Corrupted");
                break;
            }

            n.run();
        }
    }


    static Node getNodeFromID(String id)
    {
        for(Node node : nodes.getAllNodes())
        {
            if(node.getNId().equals(id))
                return node;
        }

        return null;
    }

    static Action getActionFromID(String id)
    {
        for(Action node : nodes.getDBList())
        {
            if(node.getNId().equals(id))
                return node;
        }

        return null;
    }
}
