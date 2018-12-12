import javafx.application.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.scene.*;
import javafx.scene.Group;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Optional.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import java.io.FileOutputStream;
import java.util.UUID;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;


public class App extends Application {

    public List<Nodes> savedNodes = new ArrayList<Nodes>();

    public List<XNode> xSavedNodes = new ArrayList<XNode>();
    //public Map<String, KeyCode> map = new HashMap<String, KeyCode>();
    //public CircleNode temp = new CircleNode();


    XNodeList nodeListXML = new XNodeList();

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("JBPM");

        SplitPane root = new SplitPane();
        Scene scene = new Scene(root, 800, 600);

        VBox left = new VBox(new Label("Tools"));
        left.setStyle("-fx-background-color: #b3b3b3");
        left.setAlignment(Pos.TOP_CENTER);

        root.getItems().add(left);
        root.setDividerPosition(0, 1/(double)5);

        Pane right = new Pane(new Label("Working space"));
        right.setStyle("-fx-background-color: white");
        //right.setAlignment(Pos.TOP_CENTER);
        root.getItems().add(right);


        /*nodes = Arrays.asList(
                new Circle(50, 50, 50, Color.BLUE),
                new Circle(500, 100, 50, Color.RED),
                new Circle(400, 500, 50, Color.GREEN)
        );

        nodes.forEach(right.getChildren()::add);*/
       
        
        Button startButton = new Button("Start");
        Button endButton = new Button("End");
        Button DBButton = new Button("Add DB");
        Button printButton = new Button("Print");
        Button connectionButton = new Button("Connection");
        Button save = new Button("Save");
        //Button saveNodes = new Button("Save Nodes");
        
        left.setSpacing(30);

        startButton.setStyle(
            "-fx-background-radius: 5em; " +
            "-fx-min-width: 75px; " +
            "-fx-min-height: 75px; " +
            "-fx-max-width: 75px; " +
            "-fx-max-height: 75px;"            
        );
        
        endButton.setStyle(
            "-fx-background-radius: 5em; " +
            "-fx-min-width: 75px; " +
            "-fx-min-height: 75px; " +
            "-fx-max-width: 75px; " +
            "-fx-max-height: 75px;"
        );

        printButton.setStyle(
            "-fx-background-radius: 0; " +
            "-fx-min-width: 100px; " +
            "-fx-min-height: 30px; " +
            "-fx-max-width: 100px; " +
            "-fx-max-height: 30px;"
        );

        connectionButton.setStyle(
            "-fx-background-radius: 0; " +
            "-fx-min-width: 100px; " +
            "-fx-min-height: 30px; " +
            "-fx-max-width: 100px; " +
            "-fx-max-height: 30px;"
        );

        DBButton.setStyle(
            "-fx-background-radius: 0; " +
            "-fx-min-width: 100px; " +
            "-fx-min-height: 30px; " +
            "-fx-max-width: 100px; " +
            "-fx-max-height: 30px;"
        );
        DBButton.setLayoutX(320);
        DBButton.setLayoutY(560);


        save.setStyle(
            "-fx-background-radius: 0; " +
            "-fx-min-width: 100px; " +
            "-fx-min-height: 30px; " +
            "-fx-max-width: 100px; " +
            "-fx-max-height: 30px;"
        );
        save.setLayoutX(430);
        save.setLayoutY(560);
/*
        saveNodes.setStyle(
            "-fx-background-radius: 0; " +
            "-fx-min-width: 100px; " +
            "-fx-min-height: 30px; " +
            "-fx-max-width: 100px; " +
            "-fx-max-height: 30px;"
        );
        saveNodes.setLayoutX(320);
        saveNodes.setLayoutY(560);

*/

        left.getChildren().add(startButton);
        left.getChildren().add(endButton);      
        left.getChildren().add(printButton);
        //left.getChildren().add(connectionButton);
        right.getChildren().add(DBButton);
        right.getChildren().add(save); 

        startButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                Circle circle1 = new Circle();
                StartNode circle = new StartNode(circle1, Types.NodeType(Types.NodeTypes.START), UUID.randomUUID());

                XStartNode xCircle = new XStartNode(Types.NodeType(Types.NodeTypes.START), UUID.randomUUID());

                circle.setStyle(
                    "-fx-background-radius: 5em; " +
                    "-fx-min-width: 45px; " +
                    "-fx-min-height: 45px; " +
                    "-fx-max-width: 45px; " +
                    "-fx-max-height: 45px;" +
                    "-fx-background-color: #009933;" +
                    "-fx-text-fill: black; "
                );
                // position the node
                circle.setLayoutX(40 + circle.getPrefWidth());
                circle.setLayoutY(40);

                // add the node to the working space pane
                right.getChildren().add(circle);

                /*if(savedNodes.size() > 0)
                {
                    Nodes last = savedNodes.get(savedNodes.size()-1);

                }*/

                savedNodes.add(circle);
                
                xSavedNodes.add(xCircle);
                nodeListXML.addStartNode(xCircle);
            }
        });

        endButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Circle circle1 = new Circle();

                EndNode circle = new EndNode(circle1, Types.NodeType(Types.NodeTypes.END), UUID.randomUUID());

                XEndNode xCircle = new XEndNode(Types.NodeType(Types.NodeTypes.END), UUID.randomUUID());

                circle.setStyle(
                    "-fx-background-radius: 5em; " +
                    "-fx-min-width: 45px; " +
                    "-fx-min-height: 45px; " +
                    "-fx-max-width: 45px; " +
                    "-fx-max-height: 45px;" +
                    "-fx-background-color: #cc0000;" +
                    "-fx-text-fill: black; "
                );
                // position the node
                circle.setLayoutX(40 + circle.getPrefWidth());
                circle.setLayoutY(40);

                // add the node to the working space pane
                right.getChildren().add(circle);
                savedNodes.add(circle);
                
                xSavedNodes.add(xCircle);
                nodeListXML.addEndNode(xCircle);
            }
        });

        printButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Rectangle rectangle1 = new Rectangle();
                CircleNode rectangle = new CircleNode(rectangle1, Types.NodeType(Types.NodeTypes.CIRCLE), UUID.randomUUID());

                XCircleNode xRectangle = new XCircleNode(Types.NodeType(Types.NodeTypes.CIRCLE), UUID.randomUUID());

                rectangle.setStyle(
                    "-fx-background-radius: 0; " +
                    "-fx-min-width: 45px; " +
                    "-fx-min-height: 45px; " +
                    "-fx-max-width: 45px; " +
                    "-fx-max-height: 45px;" +
                    "-fx-background-color: #99b3e6;" +
                    "-fx-text-fill: black; "
                );
                // position the node
                rectangle.setLayoutX(40 + rectangle.getPrefWidth());
                rectangle.setLayoutY(40);

                // add the node to the working space pane
                right.getChildren().add(rectangle);
                savedNodes.add(rectangle);
                
                xSavedNodes.add(xRectangle);
                nodeListXML.addCircleNode(xRectangle);
            }
        });


        /*connectionButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Line line1 = new Line();
                Lines line = new Lines(savedNodes, line1);
                right.getChildren().add(line1);
            }
        });*/

        DBButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {


                if(xSavedNodes.size() > 0)
                {

                    DBAction db = new DBAction();

                    XDBAction xDb = new XDBAction(Types.NodeType(Types.NodeTypes.DB), UUID.randomUUID());

                    TextInputDialog dialog = new TextInputDialog();
    
                    dialog.setTitle("Server");
                    dialog.setHeaderText("Enter Database Server:");
    
                    Optional<String> result = dialog.showAndWait();
                    String s;
    
                    if (result.isPresent()) {
                        s = result.get();  
                        db.setNameProperty(s);
                        
                        xDb.setNameProperty(s);
                    }

                    XNode last = xSavedNodes.get(xSavedNodes.size()-1);

                    xDb.setConnectedNode(last.getNId());
                    last.setConnectedAction(xDb.getNId());

                    nodeListXML.addDBNode(xDb);

                    System.out.println("Attached to node");     
                }

                else
                {
                    System.out.println("No Nodes to Attach to");     

                }
                
            }
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                /*for(Nodes node : savedNodes)
                {
                    System.out.println(node.getNId() + " " + node.getType());
                }*/


                xSavedNodes.get(0).setNextNode(xSavedNodes.get(1).getNId());

                System.out.println("ID : " + xSavedNodes.get(0).getNId());
                System.out.println("Previous ID : " + xSavedNodes.get(0).getPreviousNode());
                System.out.println("Next ID : " + xSavedNodes.get(0).getNextNode());
                System.out.println();

                for (int i = 1; i < xSavedNodes.size()-1; i++)
                {
                    xSavedNodes.get(i).setNextNode(xSavedNodes.get(i+1).getNId());
                    xSavedNodes.get(i).setPreviousNode(xSavedNodes.get(i-1).getNId());

                    System.out.println("ID : " + xSavedNodes.get(i).getNId());
                    System.out.println("Previous ID : " + xSavedNodes.get(i).getPreviousNode());
                    System.out.println("Next ID : " + xSavedNodes.get(i).getNextNode());
                    System.out.println();
                }

                xSavedNodes.get(xSavedNodes.size()-1).setPreviousNode(xSavedNodes.get(xSavedNodes.size()-2).getNId());

                System.out.println("ID : " + xSavedNodes.get(xSavedNodes.size()-1).getNId());  
                System.out.println("Previous ID : " + xSavedNodes.get(xSavedNodes.size()-1).getPreviousNode());  
                System.out.println("Next ID : " + xSavedNodes.get(xSavedNodes.size()-1).getNextNode());
                System.out.println();

                for (int i = 0; i < xSavedNodes.size(); i++)
                {
                    System.out.println(xSavedNodes.get(i).getNId() + " " + xSavedNodes.get(i).getType());
                }
                System.out.println();

                try {

                    JAXBContext contextObj = JAXBContext.newInstance(XNodeList.class);
                    Marshaller marshallerObj = contextObj.createMarshaller();
                    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
                    marshallerObj.marshal(nodeListXML, new FileOutputStream("./../nodes.xml"));
                    
                } catch (Exception e) {

                    System.out.println(e);
                }
                
            }
        });

        /*saveNodes.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                nodes = temp.getList();    

                for (int i = 0; i < nodes.size(); i++)
                    System.out.printf("Key : %s and Value: %s %n", nodes.get(i), nodes.get(i).getId());
            }
        });

        


        map.put("A", KeyCode.A);
        map.put("B", KeyCode.B);
        map.put("C", KeyCode.C);
        map.put("D", KeyCode.D);
        map.put("E", KeyCode.E);
        map.put("F", KeyCode.F);
        map.put("G", KeyCode.G);
        map.put("H", KeyCode.H);
        map.put("I", KeyCode.I);
        map.put("J", KeyCode.J);
        map.put("K", KeyCode.K);
        map.put("L", KeyCode.L);
        map.put("M", KeyCode.M);
        map.put("N", KeyCode.N);
        map.put("O", KeyCode.O);
        map.put("P", KeyCode.P);
        map.put("Q", KeyCode.Q);
        map.put("R", KeyCode.R);
        map.put("S", KeyCode.S);
        map.put("T", KeyCode.T);
        map.put("U", KeyCode.U);
        map.put("V", KeyCode.V);
        map.put("W", KeyCode.W);
        map.put("X", KeyCode.X);
        map.put("Y", KeyCode.Y);
        map.put("Z", KeyCode.Z);

        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
              
            if(key.getCode() == map.get(nodes.get(0).getId())) {
                scene.addEventHandler(KeyEvent.KEY_PRESSED, (k) -> {
                    if(k.getCode() == map.get(nodes.get(1).getId())) {
                
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Output");
                        alert.setHeaderText(null);
                        alert.setContentText("Key pressed");

                        alert.showAndWait();
                    }
                });
            }
        });

*/

        // finally, show the stage
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        launch(args);
        //ToXML.run();
    }
}
