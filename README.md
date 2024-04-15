[# Documentação do Projeto ConsuLEDS

## Introdução

O projeto ConsuLEDS é um sistema de consulta que permite buscar concursos disponíveis para candidatos e candidatos elegíveis para concursos. Ele carrega informações sobre candidatos e concursos a partir de arquivos `.txt` e realiza consultas com base no CPF do candidato ou no código do concurso.

## Classes

### Main

A classe `Main` é a classe principal do projeto. Ela é responsável por inicializar o sistema, carregar os dados dos candidatos e concursos e exibir o menu de opções para o usuário.

#### Métodos

- `main(String[] args)`: Método principal que inicializa o sistema e gerencia as consultas.

### Concurso

A classe `Concurso` representa um concurso público. Ela contém informações como órgão, edital, código e áreas de vagas.

#### Atributos

- `orgao`: String que representa o órgão responsável pelo concurso.
- `edital`: String que representa o edital do concurso.
- `codigo`: String que representa o código do concurso.
- `areas`: ArrayList de Strings que representa as áreas de vagas do concurso.

### Candidato

A classe `Candidato` representa um candidato. Ela contém informações como nome, data de nascimento, CPF e profissões.

#### Atributos

- `nome`: String que representa o nome do candidato.
- `dataNascimento`: Objeto da classe `Data` que representa a data de nascimento do candidato.
- `cpf`: String que representa o CPF do candidato.
- `profissoes`: ArrayList de Strings que representa as profissões do candidato.

### Data

A classe `Data` representa uma data, com dia, mês e ano.

#### Atributos

- `dia`: String que representa o dia.
- `mes`: String que representa o mês.
- `ano`: String que representa o ano.

### EntradaTXT

A classe `EntradaTXT` é uma classe base para leitura de arquivos `.txt`. Ela contém um Scanner para ler o arquivo.

#### Atributos

- `input`: Scanner para ler o arquivo.

#### Métodos

- `EntradaTXT(String caminho)`: Construtor que inicializa o Scanner com o caminho do arquivo.

### EntradaCandidatoTXT

A classe `EntradaCandidatoTXT` herda de `EntradaTXT` e é especializada para ler arquivos de candidatos.

#### Métodos

- `montarListaDeCandidatos(ArrayList<Candidato> listaDeCandidatos)`: Lê o arquivo de candidatos e preenche a lista de candidatos.

### EntradaConcursoTXT

A classe `EntradaConcursoTXT` herda de `EntradaTXT` e é especializada para ler arquivos de concursos.

#### Métodos

- `montarListaDeConcursos(ArrayList<Concurso> listaDeConcursos)`: Lê o arquivo de concursos e preenche a lista de concursos.

### Consulta

A classe `Consulta` contém métodos para realizar consultas com base no CPF do candidato ou no código do concurso.

#### Métodos

- `imprimirArraylist(ArrayList<Object> lista)`: Imprime uma lista de objetos. A lista contém todos os objetos do tipo Candidato ou todos os objetos do tipo Concurso.
- `consultaPorCPF(ArrayList<Candidato> listadeCandidatos, ArrayList<Concurso> listaDeConcursos)`: Realiza uma consulta por CPF. Chama o método `listaConcursosParaUmCandidato` para montar uma lista com os concursos para os quais o candidato é elegível; chama o método `imprimirArraylist` que lista os mesmos concursos (órgãos, códigos e editais) na tela. Este método público é invocado pela `Main`.
- `consultaPorCodigo(ArrayList<Candidato> listadeCandidatos, ArrayList<Concurso> listaDeConcursos)`: Realiza uma consulta por código. Chama o método `listaCandidatosParaUmConcurso` para montar uma lista com os candidatos elegíveis para este concurso; chama o método `imprimirArraylist` que lista os mesmos candidatos (nome, data de nascimento e o CPF) na tela. Este método público é invocado pela `Main`.
- `listaConcursosParaUmCandidato(Candidato candidato, ArrayList<Concurso> listaDeConcursos)`: Retorna uma lista de concursos para um candidato.
- `listaCandidatosParaUmConcurso(Concurso concurso, ArrayList<Candidato> listaDeCandidatos)`: Retorna uma lista de candidatos elegíveis para um concurso.
- `encontrarCandidatoPorCPF(String CPF, ArrayList<Candidato> listaDeCandidatos)`: Encontra um candidato por CPF.
- `encontrarConcursoPorCodigo(String cod, ArrayList<Concurso> listaDeConcursos)`: Encontra um concurso por código.

](README.md)