import java.util.UUID;

public abstract class Action
{
    protected String id;
    protected UUID uuid;
    String type;

    abstract String getId();
    abstract void setId(String id);

    abstract UUID getUUId();

    abstract String getType(); 

    abstract void setType(String type);

    abstract void run();
}