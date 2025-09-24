import java.util.Scanner;

public class CassinoApp {
    private Conta conta;
    private Jogos jogos;
    private Scanner input;

    public CassinoApp(){
        conta = new Conta();
        jogos = new Jogos();
        input = new Scanner(System.in);
    }

    public void iniciar(){
        boolean sair = false;
        System.out.println("Seja bem-vindo ao tigrinho!!!!");

        while (!sair) {
            System.out.println("=================================");
            System.out.println("(1) - Jogar");
            System.out.println("(2) - Depositar");
            System.out.println("(3) - Sacar");
            System.out.println("(4) - Consultar saldo");
            System.out.println("(5) - Sair");
            System.out.println("=================================");
            int opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:{
                    menuJogos();
                }
                case 2:{
                    System.out.print("Valor do depósito: R$");
                    conta.depositar(Double.parseDouble(input.nextLine()));
                    break;
                }
                case 3:{
                    System.out.print("Valor do saque: R$");
                    conta.sacar(Double.parseDouble(input.nextLine()));
                    break;
                }
                case 4:{
                    System.out.println("Seu saldo: R$" + conta.getSaldo());
                    break;
                }
                case 5:{
                    System.out.println("Obrigado por jogar!");
                    sair = true;
                    break;
                }
                default: {
                    System.out.println("Opção inválida.");
                    break;
                }
            }
        }
    }

    private void menuJogos(){

        boolean voltar = false;
        while (!voltar) {
            System.out.println("=================================");
            System.out.println("Escolha um jogo:");
            System.out.println("(1) - Ímpar ou Par (x2)");
            System.out.println("(2) - Pedra, Papel e Tesoura (x3)");
            System.out.println("(3) - Adivinhe o Número (x5)");
            System.out.println("(4) - Voltar");
            System.out.println("=================================");
            int opcao = Integer.parseInt(input.nextLine());

            switch (opcao){
                case 1:{
                    jogos.imparOuPar(conta);
                    break;
                }
                case 2:{
                    jogos.pedraPapelTesoura(conta);
                    break;
                }
                case 3:{
                    jogos.adivinheNumero(conta);
                    break;
                }
                case 4:{
                    voltar = true;
                    break;
                }
                default:{
                    System.out.println("Opção inválida.");
                    break;
                }
            }
        }
    }
}
