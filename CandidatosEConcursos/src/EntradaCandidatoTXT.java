import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class EntradaCandidatoTXT extends EntradaTXT {
    public EntradaCandidatoTXT(String caminho) {
        super(caminho);
    }

    public void montarListaDeCandidatos(ArrayList<Candidato> listaDeCandidatos) {
        String linha;
        try {
            while ((linha = input.nextLine()) != null){

                // Dividir a linha em partes usando a regex
                String[] partes = linha.split("\\s(?=\\d)", 2); // Divide até o primeiro 'space' seguido de algarismo

                // Atribuir nome e sobrenome
                String nome = partes[0];

                // Extrair o restante das informações
                String[] infoRestante = partes[1].split(" ");

                // Extrair dia, mês e ano da data de nascimento
                String[] dataNascimento = infoRestante[0].split("/");
                String dia = dataNascimento[0];
                String mes = dataNascimento[1];
                String ano = dataNascimento[2];

                // Criar data de nascimento
                Data dtNascimento = new Data(dia, mes, ano);

                // Atribuir CPF
                String cpf = infoRestante[1];

                // Extrair lista de profissões
                String profissoesString = linha.substring(linha.indexOf("[") + 1, linha.indexOf("]"));
                String[] profissoesArray = profissoesString.split(", ");
                ArrayList<String> profissoes = new ArrayList<>(Arrays.asList(profissoesArray));

                Candidato c = new Candidato(nome, dtNascimento, cpf, profissoes);
                listaDeCandidatos.add(c);
            }
        } catch (NoSuchElementException e){
            System.out.println("Todas as linhas do arquivo candidatos.txt foram lidas.\n\n\n\n\n\n");
        }
    }
}
