import java.io.FileOutputStream;  
import java.util.*;
import java.lang.*;
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;

public class ToXML {    

    public static void run() throws Exception{ 

        CircleNode c1 = new CircleNode(1);
        CircleNode c2 = new CircleNode(2);
        CircleNode c3 = new CircleNode(3);

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
