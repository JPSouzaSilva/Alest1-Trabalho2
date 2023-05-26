import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GerenciadorListaRua {

    Scanner input = new Scanner(System.in);
    ListaDeRuas listaDeRuas;

    public GerenciadorListaRua(){
        listaDeRuas = new ListaDeRuas();
    }

    public void menu(){
        String opcao;
        do {
            System.out.println("----MENU----");
            System.out.println("Para encerrar o programa aperte: 0");
            System.out.println("Para listar todas as ruas com  suas repectivas sinalizações: 1");
            System.out.println("Para listar o nome da Rua/Av/Trav com mais sinalizações instaladas: 2");
            System.out.println("Para listar o mês com maior numero de sinalizações: 3");
            System.out.println("Para entrar em modo navegação: 4");



            System.out.println("Informa e opção desejada: ");
            opcao = input.nextLine();

            switch(opcao) {
                case "0":
                    System.out.println("Fim do programa");
                    break;
                case "1":
                    System.out.println(listaDeRuas.listaTudo());
                    break;
                case "2":
                    System.out.println(listaDeRuas.maiorNumSinalizacao());
                    break;
                case "3":
                    System.out.println("O mês com mais sinalizações instaladas foi: "+ listaDeRuas.mesMaisSinalizacao());
                    break;
                case "4":
                    nav();
                    break;
            }

        } while(!opcao.equals("0"));
    }

    public void nav(){
        System.out.println("--Você entrou em modo navegação--");
        listaDeRuas.reset();
        System.out.println(listaDeRuas.primeiraRuaInfo());

        String opcao;
        do {
            System.out.println("--Sub-Menu-Navegação--");
            System.out.println("Digite 0 para sair do modo de navegação.");
            System.out.println("Digite 1 para retroceder de rua.");
            System.out.println("Digite 2 para avançar de rua");
            System.out.println("Informa e opção desejada: ");
            opcao = input.nextLine();

            switch(opcao) {
                case "0": System.out.println("Fim do programa");
                    break;
                case "1":
                    int opcao2 =1;
                    String resposta = listaDeRuas.navegacao(opcao2);
                    System.out.println(resposta);
                    if(resposta.equals("Erro, foi selecionado um Nodo null para fazer a navegação.")){
                        opcao = "0";
                        break;
                    }
                    break;
                case "2":
                    int opcao3 = 2;
                    String resposta3 = listaDeRuas.navegacao(opcao3);
                    System.out.println(resposta3);
                    if(resposta3.equals("Erro, foi selecionado um Nodo null para fazer a navegação.")){
                        opcao = "0";
                        break;
                    }
                    break;
            }

        } while(!opcao.equals("0"));
    }


    public void insereDados(){

        String linhas[] = new String[110000];
        int numLinhas = 0;

        Path filePath = Paths.get("dataEditado.csv");

        // Ler o arquivo
        try ( BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset())) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                linhas[numLinhas] = line;
                numLinhas++;
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.format("Erro na leitura do arquivo: ", e.getMessage());
        }

        // Mude numLinhas para algum numero pequeno para executar testes mais rapidamente.
        // Ex:
        // for (int i = 0; i < 50; i++) {
        for (int i = 0; i < numLinhas; i++) {
            String[] campos = linhas[i].split(";");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime dateTime = LocalDateTime.parse(campos[0], formatter);
            int anoDataExtracao = dateTime.getYear();
            int mesDataExtracao = dateTime.getMonthValue();
            int diaDataExtracao = dateTime.getDayOfMonth();
            int horaDataExtracao = dateTime.getHour();
            int minDataExtracao = dateTime.getMinute();

            LocalDate date = null;
            String descricao = campos[1];
            String estado = campos[2];
            String complemento = campos[3];


            int anoImplantacao = 0;
            int mesImplantacao = 0;
            int diaImplantacao = 0;
            if(!campos[4].equals("")) {
                if(campos[4].contains("-"))
                    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                else
                    formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                 date = LocalDate.parse(campos[4], formatter);
                anoImplantacao = date.getYear();
                mesImplantacao = date.getMonthValue();
                diaImplantacao = date.getDayOfMonth();
            }

            String logradouro = campos[5].split(" ", 2)[0];
            String nomeLog = campos[5].split(" ", 2)[1];

            double numInicial;
            if(campos[6].equals(""))
                numInicial = 0;
            else
                numInicial = Double.parseDouble(campos[6]);

            double numFinal;
            if(campos[7].equals(""))
                numFinal = 0;
            else
                numFinal = Double.parseDouble(campos[7]);

            String defronte = campos[8];
            String cruzamento = campos[9];
            String lado = campos[10];
            String fluxo = "";
            if(campos.length>=12)
                fluxo = campos[11];
            String localInstalacao = "";
            if(campos.length>=13)
                localInstalacao = campos[12];


           
            Sinalizacao sinalizacao = new Sinalizacao(descricao,date,numInicial,numFinal,lado,localInstalacao);

            listaDeRuas.insereOrdenado(logradouro,nomeLog,sinalizacao);
        }
    }
}
