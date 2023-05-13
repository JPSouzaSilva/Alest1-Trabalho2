import java.time.LocalDate;

public class Sinalizacao {
    private String descricao;
    private LocalDate dataImplantacao;
    private int numInicial;
    private int numFinal;
    private String lado;
    private String local;
    
    public Sinalizacao(String descricao, LocalDate implantacao, int numInicial, int numFinal, String lado, String local) {
        this.descricao = descricao;
        this.dataImplantacao = implantacao;
        this.numInicial = numInicial;
        this.numFinal = numFinal;
        this.lado = lado;
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataImplantacao() {
        return dataImplantacao;
    }

    public int getNumInicial() {
        return numInicial;
    }

    public int getNumFinal() {
        return numFinal;
    }

    public String getLado() {
        return lado;
    }

    public String getLocal() {
        return local;
    }

    @Override
    public String toString() {
        return "Sinalizacao [descricao=" + descricao
         + ", implantacao=" + dataImplantacao
          + ", numInicial=" + numInicial
                + ", numFinal=" + numFinal
                 + ", lado=" + lado
                  + ", local=" + local + "]";
    }
}