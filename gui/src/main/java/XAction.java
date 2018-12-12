import java.util.UUID;

public abstract class XAction
{
    protected String nId;
    protected UUID uuid;
    String type;

    abstract String getNId();
    abstract void setNId(String id);

    abstract UUID getUUId();

    abstract String getType(); 

    abstract void setType(String type);

    abstract String run(String element);
}