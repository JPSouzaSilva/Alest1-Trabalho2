public class ListaDeRuas {
    
    private class Node {
        public Rua element;
        public Node next;
        public Node prev;
        
        public Node(Rua rua) {
            element = rua;
            next = null;
            prev = null;
        }
    }

    private Node header;
    private Node trailer;
    private int count;
    
    public ListaDeRuas() {
        header = null;
        trailer = null;
        count = 0;
    }

    

    
}
