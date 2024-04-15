import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class EntradaConcursoTXT extends EntradaTXT {
    public EntradaConcursoTXT(String caminho) {
        super(caminho);
    }

    public void montarListaDeConcursos(ArrayList<Concurso> listaDeConcursos) {
        String linha;
        try {
            while ((linha = input.nextLine()) != null){

                // Dividir a linha em partes usando espaços em branco como delimitador
                String[] partes = linha.split(" ");

                // Atribuir informações à classe Concurso
                String orgao = partes[0];
                String edital = partes[1];
                String codigo = partes[2];
                String profissoesString = linha.substring(linha.indexOf("[") + 1, linha.indexOf("]"));
                String[] profissoesArray = profissoesString.split(", ");
                ArrayList<String> areas = new ArrayList<>(Arrays.asList(profissoesArray));

                // Criar objeto Concurso
                Concurso c = new Concurso(orgao, edital, codigo, areas);
                listaDeConcursos.add(c);
            }
        } catch (NoSuchElementException e){
            System.out.println("Todas as linhas do arquivo concursos.txt foram lidas.\n\n\n\n\n\n");
        }
    }
}
