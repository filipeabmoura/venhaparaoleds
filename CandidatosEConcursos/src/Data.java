public class Data {
    private String dia;
    private String mes;
    private String ano;

    public Data(String dia, String mes, String ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
