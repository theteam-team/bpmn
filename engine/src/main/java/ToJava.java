import java.io.File;  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;

public class ToJava {  

    public static void run() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(CircleNodeList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
     
        CircleNodeList nodes = (CircleNodeList) jaxbUnmarshaller.unmarshal( new File("./../nodes.xml") );
     
        for(CircleNode node : nodes.getList())
        {
            node.run();
        }
        System.out.println(nodes);
    }
}
