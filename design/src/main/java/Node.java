import java.util.UUID;

public abstract class Node
{
    protected String nId;
    protected UUID uuid;
    String type;

    abstract String getNId();
    abstract void setNId(String id);

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