import java.util.ArrayList;

public class Candidato {
    private String nome;
    private Data dataNascimento;
    private String cpf;
    private ArrayList<String> profissoes;

    public Candidato(String nome, Data dataNascimento, String cpf, ArrayList<String> profissoes){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.profissoes = profissoes;
    }


    public String getCpf() {
        return this.cpf;
    }

    public ArrayList<String> getProfissoes() {
        return this.profissoes;
    }

    @Override
    public String toString() {
        return this.nome + "\t\tData de Nascimento: " + this.dataNascimento + "\t\tCPF: " + this.cpf;
    }
}
