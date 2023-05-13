import java.time.LocalDate;

public class ListaDeSinalizacoes {
    
    private class Node {
        public Sinalizacao element;
        public Node next;
        
        public Node(Sinalizacao element) {
            this.element = element;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public ListaDeSinalizacoes() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(Sinalizacao element)  { 
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    public int size() {
        return count;
    }

    public int getMes(int index) {
        // retorna o mês de implantação da iésima sinalização
        return -1;
    }

    public LocalDate getDataImplantacao(int index) {
        // retorna data de implantação da iésima sinalização, para depois comparar qual é maior ou menor
        
    }

    public LocalDate getMenorData()  {
        // retorna a data da primeira sinalização instalada (considerando esta lista)
        Sinalizacao aux = head.element;
        return aux.getDataImplantacao();
    }

    public LocalDate getMaiorData() {
        // retorna a data da última sinalização instalada (considerando esta lista)
        Sinalizacao aux = tail.element;
        return aux.getDataImplantacao();
    }

    public void reset() {
        head = null;
        tail = null;
        count = 0;
    }

    public void next() {

    }






}
