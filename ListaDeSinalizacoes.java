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

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public Sinalizacao get(int index) {
        if ((index < 0) || (index >= count)) {
            return null;
        }
        if (index == count-1)
            return tail.element;

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return aux.element;
    }

    public LocalDate getMenorData() {
        Node aux = head;
        LocalDate menorDataAtual;
        LocalDate menorData = head.element.getDataImplantacao();
        for (int i = 0; i < count; i++) {
            menorDataAtual = aux.element.getDataImplantacao();
            if (menorDataAtual == null) {
                return null;
            }
            if (menorDataAtual.isAfter(menorData)) {
                menorData = menorDataAtual;
            }
            aux = aux.next;
        }
        return menorData;
    }


    public LocalDate getMaiorData() {
        Node aux = head;
        LocalDate maiorDataAtual;
        LocalDate maiorData = head.element.getDataImplantacao();;
        for (int i = 0; i < count; i++) {
            maiorDataAtual = aux.element.getDataImplantacao();
            if (maiorDataAtual == null) {
                return null;
            }
            if (maiorDataAtual.isBefore(maiorData)){
                maiorData = maiorDataAtual;
            }
            aux = aux.next;
        }
        return maiorData;
    }
    
    public int getMes(int index) {
        if ((index < 0) || (index >= count)) {
            return -1;
        }
        if (index == count-1) {
            LocalDate dataImplantacao = tail.element.getDataImplantacao();
            if (dataImplantacao == null) {
                return -1;
            }
            return tail.element.getDataImplantacao().getMonthValue();
        }
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        LocalDate dataImplantacao = aux.element.getDataImplantacao();
        if(dataImplantacao==null){
            return -1;
        }
        return dataImplantacao.getMonthValue();
    }

    public LocalDate getDataImplantacao(int index) {
        if ((index < 0) || (index >= count)) {
            return null;
        }
        if (index == count-1)
            return tail.element.getDataImplantacao();

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return aux.element.getDataImplantacao();
    }

    public String listaSinalizacoes(){
        Node aux = head;
        String s = "";
        while(aux!=null){
            s = s + aux.element.toString();
            aux = aux.next;
            s = s + "\n";
        }
        return s;
    }
}
