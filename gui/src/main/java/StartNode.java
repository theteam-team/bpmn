import javafx.application.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.*;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Node.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Alert.*;
import javafx.scene.input.*;
import javafx.scene.input.MouseEvent.*;
import javafx.scene.input.KeyEvent.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.stage.Stage;

import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = { "previousNode", "nextNode", "connectedAction"})
class StartNode extends Nodes
{

    private String connectedAction = null;

    private String previousNode = null;
    private String nextNode = null;

    private double x = 0;
    private double y = 0;
    // mouse position
    private double mousex = 0;
    private double mousey = 0;
    private Circle view;
    private boolean dragging = false;
    private boolean moveToFront = true;

    public StartNode()
    {
        init();
    }

    public StartNode(Circle view, String type, UUID nId)
    {
        this.view = view;
        this.type = type;
        this.nId = nId.toString();
        this.uuid = nId;

        getChildren().add(view);
        init();
    }

    @XmlAttribute
    public String getNId()
    {
        return nId.toString();  
    }

    public void setNId(String nId)
    {
        this.nId = nId;
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


    //return the dragging
    public boolean isDragging() {
        return dragging;
    }

     //return the view
    public Circle getView() {
        return view;
    }

     //param moveToFront the moveToFront to set
    public void setMoveToFront(boolean moveToFront) {
        this.moveToFront = moveToFront;
    }

     //return the moveToFront
    public boolean isMoveToFront() {
        return moveToFront;
    }
    
    public void removeNode(Circle n) {
        getChildren().remove(n);
    }

    public void init() {

        onMousePressedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                /*if (event.getClickCount() == 2) {
                    TextInputDialog dialog = new TextInputDialog();
 
                    dialog.setTitle("Input");
                    dialog.setHeaderText("Enter a capital letter:");
 
                    Optional<String> result = dialog.showAndWait();
                    String s;
  
                    if (result.isPresent()) {
                        s = result.get();  
                        view.setId(s);
                        nodes.add(view);
                    }  
                 } */  

                // record the current mouse X and Y position on Node
                mousex = event.getSceneX();
                mousey = event.getSceneY();

                x = getLayoutX();
                y = getLayoutY();

                if (isMoveToFront()) {
                    toFront();
                }
            }
        });

        //Event Listener for MouseDragged
       onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                // Get the exact moved X and Y

                double offsetX = event.getSceneX() - mousex;
                double offsetY = event.getSceneY() - mousey;

                x += offsetX;
                y += offsetY;

                double scaledX = x;
                double scaledY = y;

                setLayoutX(scaledX);
                setLayoutY(scaledY);

                dragging = true;

                // again set current Mouse x AND y position
                mousex = event.getSceneX();
                mousey = event.getSceneY();

                event.consume();
            }
        });

        onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if(App.drawingLine)
                {
                    if(App.firstNode == null)
                        App.firstNode = (Nodes)event.getSource();
                    else
                        {
                            App.drawingLine = false;
                            App.firstNode = null;

                            Line line = new Line(0, 100, 400, 50);
                            App.right.getChildren().add(line);
                        }
                }
                else
                    dragging = false;

            }
        });  

    }

    @Override
    void run()
    {

    }

}
