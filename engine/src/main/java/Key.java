interface KeyListener {
    boolean keyPressed(String event);
}

class Key implements KeyListener {

    @Override
    public boolean keyPressed(String event) {

        Node n = ToJava.getNodeFromID(event);

        if(n == null)
            return false;
        
        if(!n.getType().equals(Types.NodeType(Types.NodeTypes.START)))
            return false;


        System.out.println("\n Process Found");  
        System.out.println("Execute Circle Tasks");  

        while(n.getNextNode() != null)
        {
            n = ToJava.getNodeFromID(n.getNextNode());

            if(n == null)
            {
                System.out.println("ID Corrupted");
                break;
            }

            n.run();
        }

        return true;
    }

}
