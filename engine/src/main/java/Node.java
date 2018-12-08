import java.util.UUID;

public abstract class Node
{
    protected UUID id = UUID.randomUUID();
    String type;
    
    abstract void run();
}