import javafx.application.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.binding.Bindings;
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


public class App extends Application {

    public List<Circle> nodes;
    public List<Nodes> savedNodes = new ArrayList<Nodes>();
    //public Map<String, KeyCode> map = new HashMap<String, KeyCode>();
    //public CircleNode temp = new CircleNode();
    public static Pane right;

    public static boolean drawingLine = false;
    public static Nodes firstNode = null;

    public Optional<Nodes> findNodes(List<Nodes> savedNodes, double x, double y) 
    {
        return savedNodes.stream().filter(n -> n.contains(x, y)).findAny();
    }

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

        right = new Pane(new Label("Working space"));
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
        //Button readButton = new Button("Read");
        Button printButton = new Button("Print");
        Button connectionButton = new Button("Connection");
        Button deleteButton = new Button("Delete");
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

        /*readButton.setStyle(
            "-fx-background-radius: 0; " +
            "-fx-min-width: 100px; " +
            "-fx-min-height: 30px; " +
            "-fx-max-width: 100px; " +
            "-fx-max-height: 30px;"
        );*/

        printButton.setStyle(
            "-fx-background-radius: 0; " +
            "-fx-min-width: 100px; " +
            "-fx-min-height: 30px; " +
            "-fx-max-width: 100px; " +
            "-fx-max-height: 30px;"
        );

        deleteButton.setStyle(
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
        //left.getChildren().add(readButton);
        
        left.getChildren().add(printButton);
        left.getChildren().add(connectionButton);
        left.getChildren().add(deleteButton);
        right.getChildren().add(DBButton);
        right.getChildren().add(save); 

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Circle circle1 = new Circle();
                StartNode circle = new StartNode(circle1, Types.NodeType(Types.NodeTypes.START), UUID.randomUUID());
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
                savedNodes.add(circle);
            }
        });

        endButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Circle circle1 = new Circle();
                EndNode circle = new EndNode(circle1, Types.NodeType(Types.NodeTypes.START), UUID.randomUUID());
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
            }
        });

        /*readButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Rectangle rectangle1 = new Rectangle();
                CircleNode rectangle = new CircleNode(rectangle1, Types.NodeType(Types.NodeTypes.START), UUID.randomUUID());
                rectangle.setStyle(
                    "-fx-background-radius: 0; " +
                    "-fx-min-width: 45px; " +
                    "-fx-min-height: 45px; " +
                    "-fx-max-width: 45px; " +
                    "-fx-max-height: 45px;" +
                    "-fx-background-color: #adebeb;" +
                    "-fx-text-fill: black; "
                );
                // position the node
                rectangle.setLayoutX(40 + rectangle.getPrefWidth());
                rectangle.setLayoutY(40);

                // add the node to the working space pane
                right.getChildren().add(rectangle);
            }
        });*/

        printButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //Rectangle rectangle1 = new Rectangle();
                //ProcessNode rectangle = new ProcessNode(rectangle1, Types.NodeType(Types.NodeTypes.START), UUID.randomUUID());
               /* rectangle.setStyle(
                    "-fx-background-radius: 0; " +
                    "-fx-min-width: 45px; " +
                    "-fx-min-height: 45px; " +
                    "-fx-max-width: 45px; " +
                    "-fx-max-height: 45px;" +
                    "-fx-background-color: #99b3e6;" +
                    "-fx-text-fill: black; "
                );*/
                // position the node
               // rectangle.setLayoutX(40 + rectangle.getPrefWidth());
                //rectangle.setLayoutY(40);

                // add the node to the working space pane
                //right.getChildren().add(rectangle);
                //savedNodes.add(rectangle);
            }
        });


        connectionButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //Line line1 = new Line();
                //Lines line = new Lines(savedNodes, line1);
                drawingLine = true;

                // Line line = new Line(100, 10, 10, 110);

                //Line line = new Line(0, 50, 20, 66);
                //right.getChildren().add(line);
            }
        });

        DBButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DBAction db = new DBAction();

                TextInputDialog dialog = new TextInputDialog();
 
                dialog.setTitle("Server");
                dialog.setHeaderText("Enter Database Server:");
 
                Optional<String> result = dialog.showAndWait();
                String s;
  
                if (result.isPresent()) {
                    s = result.get();  
                    db.setNameProperty(s);
                }  
                
            }
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                for (int i = 0; i < savedNodes.size(); i++)
                    System.out.println(savedNodes.get(i));

                
            }
        });


        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                scene.setOnMousePressed(e -> {
                    Optional<Nodes> maybeNode = findNodes(savedNodes, e.getSceneX(), e.getSceneY());
                    if (maybeNode.isPresent()) {
                        right.getChildren().remove(maybeNode);
                        savedNodes.remove(maybeNode);
                    }
                });
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
