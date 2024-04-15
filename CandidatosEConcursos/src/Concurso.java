import java.util.ArrayList;

public class Concurso {
    private String orgao;
    private String edital;
    private String codigo;
    private ArrayList<String> areas;

    public Concurso(String orgao, String edital, String codigo, ArrayList<String> areas){
        this.orgao = orgao;
        this.edital = edital;
        this.codigo = codigo;
        this.areas = areas;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public ArrayList<String> getAreas() {
        return this.areas;
    }

    @Override
    public String toString() {
        return this.orgao + "\t\tEdital: " + this.edital + "\t\tCodigo: " + this.codigo;
    }
}
