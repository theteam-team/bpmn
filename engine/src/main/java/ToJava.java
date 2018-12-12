import java.io.File;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;

public class ToJava {  

    final static String EXIT = "exit";

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

        Scanner in = new Scanner(System.in);

        KEvent initiater = new KEvent();

        Key responder = new Key();
   
        initiater.addListener(responder);
        String event = " ";
        
        while(true)
        {
            
            event = in.nextLine();

            if(event.equals(EXIT))
            {
                in.close();
                return;

            }

            initiater.playEvent(event);

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

    public static Action getActionFromID(String id)
    {
        for(Action node : nodes.getDBList())
        {
            if(node.getNId().equals(id))
                return node;
        }

        return null;
    }

    
}
