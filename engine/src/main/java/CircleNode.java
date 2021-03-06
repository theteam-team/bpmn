
import java.util.UUID;

import java.sql.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = { "previousNode", "nextNode", "connectedAction", "printProperty"})
class CircleNode extends Node
{

    private String connectedAction = null;

    private String previousNode = null;
    private String nextNode = null;

    private String printProperty = null;

    public CircleNode()
    {

    }

    public CircleNode(String type, UUID id)
    {
        this.type = type;
        this.nId = id.toString();
        this.uuid = id;
    }

    @XmlAttribute
    public String getNId()
    {
        return nId.toString();  
    }

    public void setNId(String id)
    {
        this.nId = id;
    }

    public UUID getUUId()
    {
        return uuid;  
    }

    @XmlAttribute
    public String getType()
    {
        return type;  
    }  

    public void setType(String type)
    {  
        this.type = type;  
    }

    @XmlElement(name = "connectedAction")
    public String getConnectedAction()
    {

        if(connectedAction != null)
            return connectedAction.toString();
        return null;
    }

    public void setConnectedAction(String connectedAction) {
        this.connectedAction = connectedAction;
    }

    @XmlElement(name = "previousNode")
    public String getPreviousNode()
    {

        if(previousNode != null)
            return previousNode.toString();
        return null;
        
    }

    public void setPreviousNode(String previousNode) {
        this.previousNode = previousNode;
    }

    @XmlElement(name = "nextNode")
    public String getNextNode()
    {

        if(nextNode != null)
            return nextNode.toString();
        return null;
    }

    public void setNextNode(String nextNode) {
        this.nextNode = nextNode;
    }

    @XmlElement(name = "printProperty")
    public String getPrintProperty()
    {

        if(printProperty != null)
            return printProperty;
        return null;
        
    }

    public void setPrintProperty(String printProperty) {
        this.printProperty = printProperty;
    }

    @Override
    void run()
    {

        // This is the process
        // This process taske is to print the value that
        // exit in printProperty if it wasn't found it will check for it
        // in the database which it is connected to 
        // if it is connected to any
              

        if(printProperty != null)
            System.out.println(printProperty);
            
        //Checking if Connected to a database
        else if(connectedAction != null)
        {

            //System.out.println(((DBAction)ToJava.getActionFromID(connectedAction)).getNameProperty());

            // Enter Data yourself
            /*try{  
                Class.forName("com.mysql.cj.jdbc.Driver");   
                
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306","root","SQLpass");  
                  
    
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT Name FROM world.city where id=1");
    
                while(rs.next())  
                    System.out.println(rs.getString(1));  
                    
                con.close();  
    
            } catch(Exception e)
            {
                System.out.println(e);
            }*/


             // Get data from design
            /*try{  
                Class.forName("com.mysql.cj.jdbc.Driver");

                String server = ((DBAction)ToJava.getActionFromID(connectedAction)).getNameProperty();
                
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://" + server,"root","SQLpass");  
                 
    
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT Name FROM world.city where id=1");
    
                while(rs.next())  
                    System.out.println(rs.getString(1));  
                    
                con.close();  
    
            } catch(Exception e)
            {
                System.out.println(e);
            }*/

            /*String v = ToJava.getActionFromID(connectedAction).run("printProperty");
            if(v != null)
                System.out.println(v);
            else
                System.out.println("No Value Found");*/

        }
        
        else
            System.out.println("No Value Found");

    }

}
