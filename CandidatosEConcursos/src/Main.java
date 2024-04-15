import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Carreganddo informações sobre Concursos e Candidatos
        ArrayList<Candidato> listadeCandidatos = new ArrayList<>();
        String caminho = System.getProperty("user.dir") + "/entrada-txt/candidatos.txt";
        EntradaCandidatoTXT entradaCandidatos = new EntradaCandidatoTXT(caminho);
        entradaCandidatos.montarListaDeCandidatos(listadeCandidatos);

        ArrayList<Concurso> listaDeConcursos = new ArrayList<>();
        caminho = System.getProperty("user.dir") + "/entrada-txt/concursos.txt";
        EntradaConcursoTXT entradaConcursos = new EntradaConcursoTXT(caminho);
        entradaConcursos.montarListaDeConcursos(listaDeConcursos);


        //Menu
        System.out.println("Bem vindo ao ConsuLEDS");
        System.out.println("Digite o número da opção desejada: ");
        System.out.println("1) Sou Candidato (buscar Concursos disponíveis para mim)");
        System.out.println("2) Sou instituição (buscar Candidatos elegíveis)");
        System.out.print(">> ");

        Scanner in = new Scanner(System.in);
        String opcao = in.nextLine();

        //Caso a opção seja inválida
        while (!opcao.equals("1") && !opcao.equals("2")){
            System.out.println("Digite o número de uma opção válida.");
            System.out.print(">> ");
            opcao = in.nextLine();
        }


        //Realizando consulta
        Consulta consulta = new Consulta();

        if(opcao.equals("1")){
            consulta.consultaPorCPF(listadeCandidatos, listaDeConcursos);
        }
        else {
            consulta.consultaPorCodigo(listadeCandidatos, listaDeConcursos);
        }

    }
}
