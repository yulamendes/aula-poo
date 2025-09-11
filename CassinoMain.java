import java.util.Scanner;
import java.util.Random;

public class CassinoMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        boolean sair = false;
        double saldo = 0.0;

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
            while (opcao < 1 || opcao > 5) {
                System.out.println("Opção inválida, insira novamente.");
                break;
            }
            switch (opcao) {
                case 1:{
                    if (saldo == 0) {
                        System.out.println("Você não possui saldo suficiente para jogar, deposite algum valor!");
                        break;
                    } else {
                        boolean sair2 = false;
                        while (!sair2) {
                            System.out.println("=================================");
                            System.out.println("Qual jogo deseja jogar? (valor multiplicador do jogo)");
                            System.out.println("(1) - Ímpar ou par(x2)");
                            System.out.println("(2) - Pedra, papel e tesoura(x3)");
                            System.out.println("(3) - Adivinhe o número(x5)");
                            System.out.println("(4) - Voltar");
                            System.out.println("=================================");
                            int opcao2 = Integer.parseInt(input.nextLine());
                            switch (opcao2) {
                                case 1:{
                                    System.out.print("Você escolheu 'Ímpar ou par', quanto deseja apostar? R$");
                                    double aposta = Double.parseDouble(input.nextLine());
                                    if (aposta > saldo) {
                                        System.out.println("Você não pode fazer uma apostar maior que seu saldo.");
                                        break;
                                    }
                                    System.out.println("Escolha entre ímpar ou par:");
                                    System.out.println("1 - Ímpar");
                                    System.out.println("2 - Par");
                                    int rand = r.nextInt(100)+1;
                                    int jogo1 = Integer.parseInt(input.nextLine());
                                    System.out.println(rand);
                                    if ((jogo1 != 1) && (jogo1 != 2)) {
                                        System.out.println("Selecione corretamente ímpar ou par.");
                                        break;
                                    } else if ((rand % 2) == 0){
                                        if (jogo1 == 1) {
                                            System.out.println("Você escolheu ímpar e o número era: "+rand+". Você perdeu R$:"+aposta);
                                            saldo -= aposta;
                                            if (saldo == 0){
                                                        System.out.println("Você perdeu tudo, deposite novamente para continuar jogando.");
                                                        sair2 = true;
                                                        break;
                                                    }
                                            break;
                                        } else {
                                            System.out.println("Você escolheu par e o número era: "+rand+". Você ganhou R$:"+(aposta*2));
                                            saldo += (aposta*2);
                                            break;
                                        }
                                    } else {
                                        if (jogo1 == 1) {
                                            System.out.println("Você escolheu ímpar e o número era: "+rand+". Você ganhou R$:"+(aposta*2));
                                            saldo += (aposta*2);
                                            break;
                                        } else {
                                            System.out.println("Você escolheu par e o número era: "+rand+". Você perdeu R$:"+(aposta));
                                            saldo -= aposta;
                                            if (saldo == 0){
                                                        System.out.println("Você perdeu tudo, deposite novamente para continuar jogando.");
                                                        sair2 = true;
                                                        break;
                                                    }
                                            break;
                                        }
                                    }

                                }
                                case 2: {
                                    System.out.print("Você escolheu 'Pedra, papel e tesoura', quanto deseja apostar? R$");
                                    double aposta = Double.parseDouble(input.nextLine());
                                    if (aposta > saldo) {
                                        System.out.println("Você não pode fazer uma apostar maior que seu saldo.");
                                        break;
                                    }
                                    System.out.println("Digite o número equivalente:");
                                    System.out.println("1 - Pedra");
                                    System.out.println("2 - Papel");
                                    System.out.println("3 - Tesoura");
                                    int jogo2 = Integer.parseInt(input.nextLine());
                                    int rand = r.nextInt(3)+1;
                                        switch (jogo2) {
                                            case 1: {
                                                if (rand == 1){
                                                    System.out.println("Empate! O computador escolheu 'Pedra' e você escolheu 'Pedra'. Você não ganhou nada.");
                                                    break;
                                                } else if (rand == 2) {
                                                    System.out.println("O computador escolheu 'Papel' e você escolheu 'Pedra'. Você perdeu R$"+aposta);
                                                    saldo -= aposta;
                                                    if (saldo == 0){
                                                        System.out.println("Você perdeu tudo, deposite novamente para continuar jogando.");
                                                        sair2 = true;
                                                        break;
                                                    }
                                                    break;
                                                } else {
                                                    System.out.println("O computador escolheu 'Tesoura' e você escolheu 'Pedra'. Você ganhou R$"+(aposta*3));
                                                    saldo += (aposta*3);
                                                }
                                            } break;
                                            case 2: {
                                                if (rand == 1){
                                                    System.out.println("O computador escolheu 'Pedra' e você escolheu 'Papel'. Você ganhou R$"+(aposta*3));
                                                    saldo += (aposta*3);
                                                    break;
                                                } else if (rand == 2) {
                                                    System.out.println("Empate! O computador escolheu 'Papel' e você escolheu 'Papel'.");
                                                    break;
                                                } else {
                                                    System.out.println("O computador escolheu 'Tesoura' e você escolheu 'Papel'. Você perdeu R$"+aposta);
                                                    saldo -= aposta;
                                                    if (saldo == 0){
                                                        System.out.println("Você perdeu tudo, deposite novamente para continuar jogando.");
                                                        sair2 = true;
                                                        break;
                                                    }
                                                }
                                            } break;
                                            case 3: {
                                                if (rand == 1){
                                                    System.out.println("O computador escolheu 'Pedra' e você escolheu 'Tesoura'. Você perdeu R$"+aposta);
                                                    saldo -= aposta;
                                                    if (saldo == 0){
                                                        System.out.println("Você perdeu tudo, deposite novamente para continuar jogando.");
                                                        sair2 = true;
                                                        break;
                                                    }
                                                } else if (rand == 2) {
                                                    System.out.println("O computador escolheu 'Papel' e você escolheu 'Tesoura'. Você ganhou R$"+(aposta*3));
                                                    saldo += (aposta*3);
                                                    break;
                                                } else {
                                                    System.out.println("Empate! O computador escolheu 'Tesoura' e você escolheu 'Tesoura'.");
                                                    break;
                                                }
                                            } break;
                                            default: {
                                                System.out.println("Opção invalida, digite uma das opções corretamente.");
                                                break;
                                            }
                                    }
                                } break;
                                case 3: {
                                    System.out.print("Você escolheu 'Adivinhe o número', quanto deseja apostar? R$");
                                    double aposta = Double.parseDouble(input.nextLine());
                                    if (aposta > saldo) {
                                        System.out.println("Você não pode fazer uma apostar maior que seu saldo.");
                                        break;
                                    }
                                    System.out.println("Escolha um número de 1 a 5. ");
                                    int jogo3 = Integer.parseInt(input.nextLine());
                                    if (jogo3 < 1 || jogo3 > 5) {
                                        System.out.println("Número inválido, tente novamente.");
                                        break;
                                    }
                                    int rand = r.nextInt(5)+1;
                                    if (rand != jogo3){
                                        System.out.println("O número era "+rand+"! Você perdeu R$"+aposta+"!");
                                        saldo -= aposta;
                                        if (saldo == 0){
                                            System.out.println("Você perdeu tudo, deposite novamente para continuar jogando.");
                                            sair2 = true;
                                            break;
                                        }
                                        break;
                                    }
                                    System.out.println("O número era "+rand+"! Parabéns, você ganhou R$"+(aposta*5));
                                    saldo += (aposta*5);
                                    break;
                                }
                                case 4: {
                                    sair2 = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Opção inválida, digite uma das opções corretamente.");
                                    break;
                                }
                            }
                        }
                    }
                } break;
                case 2: {
                    System.out.print("Qual o valor do deposito? R$");
                    double dep = Double.parseDouble(input.nextLine());
                    saldo += dep;
                    System.out.println("Deposito no valor de R$"+dep+" realizado com sucesso.");
                    break;
                }
                case 3: {
                    System.out.print("Qual o valor do saque? R$");
                    double saq = Double.parseDouble(input.nextLine());
                    if (saq > saldo) {
                        System.out.println("Valor incorreto para saque.");
                        System.out.println("Saldo atual: R$"+saldo);
                        break;
                    }else{
                        System.out.println("Saque de R$"+saq+" realizado com sucesso.");
                        saldo -= saq;
                        break;
                    }
                }
                case 4: {
                    System.out.println("Seu saldo atual é de R$"+saldo);
                    break;
                }
                case 5: {
                    System.out.println("Obrigado por escolher tigrinho.bet, até a próxima!");
                    sair = true;
                }
                break;
            }
        }
    }
}