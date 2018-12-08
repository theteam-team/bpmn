public final class Types{

    static enum NodeTypes 
    {
        START,
        CIRCLE,
        DB,
        PROCESS,
        END
    }

    static enum ConnectionTypes 
    {
        NORMAL
    }


    static String[] Nodes =    {"Start",
                        "Circle",
                        "DB",
                        "PROCESS",
                        "END"};
    
    
    static String NodeType(Types.NodeTypes type)
    {
        switch (type) {

            case START:
                return Nodes[0];
            case CIRCLE:
                return Nodes[1];
            case DB:
                return Nodes[2];
            case PROCESS:
                return Nodes[3];
            case END:
                return Nodes[4];
                
            default:
                return "NOT FOUND";

        }
    }
}