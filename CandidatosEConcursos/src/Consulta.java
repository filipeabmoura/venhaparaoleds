import java.util.ArrayList;
import java.util.Scanner;

public class Consulta {

    private void imprimirArraylist(ArrayList<Object> lista){
        for (Object obj : lista) {
            if (obj instanceof Candidato) {
                Candidato candidato = (Candidato) obj;
                System.out.println(candidato);
            } else if (obj instanceof Concurso) {
                Concurso concurso = (Concurso) obj;
                System.out.println(concurso);
            }
        }
    }


    // lista todos os concursos para o qual um candidato é elegível dado seu CPF (lido do teclado)
    public void consultaPorCPF(ArrayList<Candidato> listadeCandidatos, ArrayList<Concurso> listaDeConcursos){
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o CPF do Candidato\n>> ");
        String CPF = in.nextLine();

        Candidato candidato1 = this.encontrarCandidatoPorCPF(CPF, listadeCandidatos);

        while (candidato1 == null){
            System.out.print("Candidato não encontrado, digite novamente o CPF\n>> ");
            CPF = in.nextLine();
            candidato1 = this.encontrarCandidatoPorCPF(CPF, listadeCandidatos);
        }

        ArrayList<Concurso> concursosParaImpressao = this.listaConcursosParaUmCandidato(candidato1, listaDeConcursos);

        // Convertendo ArrayList<Candidato> para ArrayList<Object>
        ArrayList<Object> listaConcursosObject = new ArrayList<>(concursosParaImpressao);
        this.imprimirArraylist(listaConcursosObject);
    }


    // lista todos os candidatos elegíveis para um concurso dado seu código (lido do teclado)
    public void consultaPorCodigo(ArrayList<Candidato> listadeCandidatos, ArrayList<Concurso> listaDeConcursos){
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o Código do Concurso\n>> ");
        String cod = in.nextLine();

        Concurso concurso1 = this.encontrarConcursoPorCodigo(cod, listaDeConcursos);

        while (concurso1 == null){
            System.out.print("Concurso não encontrado, digite novamente o Código\n>> ");
            cod = in.nextLine();
            concurso1 = this.encontrarConcursoPorCodigo(cod, listaDeConcursos);
        }

        ArrayList<Candidato> candidatosParaImpressao = this.listaCandidatosParaUmConcurso(concurso1, listadeCandidatos);

        // Convertendo ArrayList<Candidato> para ArrayList<Object>
        ArrayList<Object> listaCandidatosObject = new ArrayList<>(candidatosParaImpressao);
        this.imprimirArraylist(listaCandidatosObject);
    }


    private ArrayList<Concurso> listaConcursosParaUmCandidato(Candidato candidato, ArrayList<Concurso> listaDeConcursos){
        ArrayList<Concurso> concursosParaOCandidato = new ArrayList<>();

        for (Concurso concurso : listaDeConcursos){
            for (String profissao : candidato.getProfissoes()){
                if (concurso.getAreas().contains(profissao)){
                    if (!concursosParaOCandidato.contains(concurso)){
                        concursosParaOCandidato.add(concurso);
                    }
                }

            }
        }

        return concursosParaOCandidato;
    }


    private ArrayList<Candidato> listaCandidatosParaUmConcurso(Concurso concurso, ArrayList<Candidato> listaDeCandidatos){
        ArrayList<Candidato> candidatosParaOConcurso = new ArrayList<>();
        for (Candidato candidato : listaDeCandidatos){
            for (String area : concurso.getAreas()){
                if (candidato.getProfissoes().contains(area)){
                    if (!candidatosParaOConcurso.contains(candidato)){
                        candidatosParaOConcurso.add(candidato);
                    }
                }
            }
        }

        return candidatosParaOConcurso;
    }


    private Candidato encontrarCandidatoPorCPF(String CPF, ArrayList<Candidato> listaDeCandidatos){
        for (Candidato candidato : listaDeCandidatos) {
            if (CPF.equals(candidato.getCpf())) {
                return candidato;
            }
        }
        return null;
    }


    private Concurso encontrarConcursoPorCodigo(String cod, ArrayList<Concurso> listaDeConcursos){
        for (Concurso concurso : listaDeConcursos) {
            if (cod.equals(concurso.getCodigo())) {
                return concurso;
            }
        }
        return null;
    }
}
