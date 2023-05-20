import java.time.LocalDate;

public class Sinalizacao {
    private String descricao;
    private LocalDate dataImplantacao;
    private double numInicial;
    private double numFinal;
    private String lado;
    private String local;
    
    public Sinalizacao(String descricao, LocalDate implantacao, double numInicial, double numFinal, String lado, String local) {
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataImplantacao() {
        return dataImplantacao;
    }

    public void setDataImplantacao(LocalDate dataImplantacao) {
        this.dataImplantacao = dataImplantacao;
    }

    public double getNumInicial() {
        return numInicial;
    }

    public void setNumInicial(double numInicial) {
        this.numInicial = numInicial;
    }

    public double getNumFinal() {
        return numFinal;
    }

    public void setNumFinal(double numFinal) {
        this.numFinal = numFinal;
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Sinalizacao{" +
                "descricao='" + descricao + '\'' +
                ", dataImplantacao=" + dataImplantacao +
                ", numInicial=" + numInicial +
                ", numFinal=" + numFinal +
                ", lado='" + lado + '\'' +
                ", local='" + local + '\'' +
                '}';
    }

}