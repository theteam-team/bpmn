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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lines extends Pane 
{
    private DoubleProperty mouseX = new SimpleDoubleProperty();
    private DoubleProperty mouseY = new SimpleDoubleProperty();

    private List<Nodes> nodes;
    private Line currentLine;
    private boolean dragActive = false;

    public Lines(List<Nodes> nodes, Line currentLine)
    {
        this.currentLine = currentLine;
        this.nodes = nodes;
        attachHandlers();
        for (int i = 0; i < nodes.size(); i++)
                    System.out.println(nodes.get(i));
    }

    public Optional<Nodes> findNode(double x, double y) 
    {
        return nodes.stream().filter(n -> n.contains(x, y)).findAny();
    }

    public void startDrag(Nodes node) 
    {
        if (dragActive)
            return;

        dragActive = true;
        currentLine = new Line();
        currentLine.setUserData(node);
        currentLine.setStartX(node.getLayoutBounds().getMaxX());
        currentLine.setStartY(node.getLayoutBounds().getMaxY());
        currentLine.endXProperty().bind(mouseX);
        currentLine.endYProperty().bind(mouseY);

        getChildren().add(currentLine);
    }

    public void stopDrag(Nodes node) 
    {
        dragActive = false;

        if (currentLine.getUserData() != node) {
            // distinct node
            currentLine.endXProperty().unbind();
            currentLine.endYProperty().unbind();
            currentLine.setEndX(node.getLayoutBounds().getMinX());
            currentLine.setEndY(node.getLayoutBounds().getMinY());
            currentLine = null;
        } else {
            // same node
            stopDrag();
        }
    }

    public void stopDrag() 
    {
        dragActive = false;

        currentLine.endXProperty().unbind();
        currentLine.endYProperty().unbind();

        getChildren().remove(currentLine);
        currentLine = null;
    }

    public void attachHandlers() 
    {
        setOnMouseMoved(e -> {
            mouseX.set(e.getSceneX());
            mouseY.set(e.getSceneY());
        });

        setOnMouseDragged(e -> {
            mouseX.set(e.getSceneX());
            mouseY.set(e.getSceneY());
        });

        setOnMousePressed(e -> {
            findNode(e.getSceneX(), e.getSceneY()).ifPresent(this::startDrag);
        });

        setOnMouseReleased(e -> {
            Optional<Nodes> maybeNode = findNode(e.getSceneX(), e.getSceneY());
            if (maybeNode.isPresent()) {
                stopDrag(maybeNode.get());
            } else {
                stopDrag();
            }
        });
    }
}
