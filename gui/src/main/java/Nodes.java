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

public abstract class Nodes extends Pane
{
    protected String nId;
    protected UUID uuid;
    String type;

    abstract String getNId();
    abstract void setNId(String nId);

    abstract UUID getUUId();

    abstract String getType(); 

    abstract void setType(String type);

    abstract String getConnectedAction();

    abstract void setConnectedAction(String connectedAction);

    abstract String getPreviousNode();

    abstract void setPreviousNode(String previousNode);

    abstract String getNextNode();

    abstract void setNextNode(String nextNode);

    abstract void run();
}
