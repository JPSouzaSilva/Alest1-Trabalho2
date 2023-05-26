import java.time.LocalDate;

public class ListaDeRuas {

    private Node header;
    private Node trailer;
    private Node current;
    private int count;

    private Node currentNav;


    private class Node {
        public Node prev;
        public Node next;
        public ListaDeSinalizacoes lista;
        public String nomeDaRua;
        public String identificadorDaRua;

        public Node(String identificadorDaRua, String nomeDaRua){
            this.identificadorDaRua = identificadorDaRua;
            this.nomeDaRua = nomeDaRua;
            lista = new ListaDeSinalizacoes();
        }
    }

    public ListaDeRuas() {
        header = new Node(null,null);
        trailer = new Node(null,null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public void insereOrdenado(String logradouroId, String nomeLog, Sinalizacao sinalizacao) {

            Node aux = contains(nomeLog);

        if (aux == null) {  // se nao contem element, insere
            Node n = new Node(logradouroId,nomeLog);
            if (header.next == trailer) {
                // se a lista está vazia
                n.prev = header;
                n.next = trailer;
                trailer.prev = n;
                header.next = n;
            }
            else if (nomeLog.compareTo(header.next.nomeDaRua)<0) {
                // se for menor que o primeiro, insere no inicio
                n.next = header.next;
                n.prev = header;
                header.next = n;
                n.next.prev = n;
            }
            else if (nomeLog.compareTo(trailer.prev.nomeDaRua)>0) {
                // se for maior que o ultimo, insere no final
                n.next = trailer;
                n.prev = trailer.prev;
                trailer.prev.next = n;
                trailer.prev = n;
            }
            else {
                // senao procura a posicao correta para insercao
                aux = header.next;
                boolean inseriu=false;
                while (aux!=trailer && !inseriu) {
                    if (nomeLog.compareTo(aux.nomeDaRua)<0) {
                        inseriu = true;
                        n.next = aux;
                        n.prev=aux.prev;
                        aux.prev.next = n;
                        aux.prev = n;
                    }
                    aux = aux.next;
                }
            }
            count++;
        } else {
            aux.lista.add(sinalizacao);
        }
    }

    public void clear() {
        header = new Node(null,null);
        trailer = new Node(null,null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public Node contains(String nomeRua) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.nomeDaRua.equals(nomeRua)) {
                return aux;
            }
            aux = aux.next;
        }
        return null;
    }

    public String listaTudo(){
        Node aux = header.next;
        String s = "";
        for(int i = 0;i<count;i++){
            s = s + aux.nomeDaRua + "\nLista de sinalizações da rua acima:\n";
            s = s +  aux.lista.listaSinalizacoes();
            aux = aux.next;
        }
        return s;
    }

    public String maiorNumSinalizacao(){
        String nome;
        Node aux = header.next;
        Node maior2 = null;
        int maior = -1;
        int numSin;

        for(int i =0; i< count; i++){
            numSin = aux.lista.size();
            if(numSin>maior){
                maior = numSin;
                maior2 = aux;
            }
            aux = aux.next;
        }
        nome = maior2.nomeDaRua;
        return nome;
    }

    public void reset(){
        currentNav = header.next;
    }

    public String navegacao(int opcao){
        String s="";


            if (opcao==1){
               currentNav = currentNav.prev;
                if (currentNav== header){
                    currentNav = currentNav.next;
                    return "Erro, foi selecionado um Nodo null para fazer a navegação.";
                }
                s = s + "O número de sinalizações da rua selecionada: " + currentNav.nomeDaRua + " é de: "  + currentNav.lista.size();
                LocalDate sinalizacao1 = currentNav.lista.getMenorData();
                if (sinalizacao1 == null){
                    return "Rua sem sinalizações cadastradas";
                }
                s = s + "\nA primeira sinalização registrada na rua é: \n" + sinalizacao1.toString();
                s = s + "\nA última sinalização registrada na rua é: \n" + currentNav.lista.getMaiorData().toString();
            } else {
                currentNav = currentNav.next;
                if (currentNav== trailer){
                    currentNav = currentNav.prev;
                    return "Erro, foi selecionado um Nodo null para fazer a navegação.";
                }
                s = s + "O número de sinalizações da rua selecionada: " + currentNav.nomeDaRua + " é de: "  + currentNav.lista.size();
                LocalDate sinalizacao1 = currentNav.lista.getMenorData();
                if (sinalizacao1 == null){
                    return "Rua sem sinalizações cadastradas";
                }
                s = s + "\nA primeira sinalização registrada na rua é: \n" + sinalizacao1.toString();
                s = s + "\nA última sinalização registrada na rua é: \n" + currentNav.lista.getMaiorData().toString();
            }
            return s;
    }

    public String primeiraRuaInfo(){
        String s = "";

        s = s + "O número de sinalizações da primeira rua é : " + header.next.nomeDaRua + " é de: "  + header.next.lista.size();
        s = s + "A primeira sinalização registrada na rua é: \n" + header.next.lista.getMenorData().toString();
        s = s + "A última sinalização registrada na rua é: \n" + header.next.lista.getMaiorData().toString();
        return s;
    }


    public int mesMaisSinalizacao() {
        Node aux = header.next;
        int mes;
        int pos = -1;
        int maior = 0;
        int[] meses = new int[12];
        while (aux != null) {
            for (int i = 0; i < aux.lista.size(); i++) {
                mes = aux.lista.getMes(i);
                switch (mes) {
                    case 1:
                        meses[0] += 1;
                        break;
                    case 2:
                        meses[1] += 1;
                        break;
                    case 3:
                        meses[2] += 1;
                        break;
                    case 4:
                        meses[3] += 1;
                        break;
                    case 5:
                        meses[4] += 1;
                        break;
                    case 6:
                        meses[5] += 1;
                        break;
                    case 7:
                        meses[6] += 1;
                        break;
                    case 8:
                        meses[7] += 1;
                        break;
                    case 9:
                        meses[8] += 1;
                        break;
                    case 10:
                        meses[9] += 1;
                        break;
                    case 11:
                        meses[10] += 1;
                        break;
                    case 12:
                        meses[11] += 1;
                        break;
                    default:

                }
            }
            aux = aux.next;
        }
        for (int i = 0; i < meses.length; i++) {
            if (meses[i] > maior) {
                maior = meses[i];
                pos = i;
            }
        }
        return pos+1;
    }
}





