public class Rua {
    private String nomeRua;
    private String idRua;
    
    public Rua(String nomeRua, String idRua) {
        this.nomeRua = nomeRua;
        this.idRua = idRua;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public String getIdRua() {
        return idRua;
    }

    @Override
    public String toString() {
        return "Rua [nomeRua=" + nomeRua + ", idRua=" + idRua + "]";
    }
}
