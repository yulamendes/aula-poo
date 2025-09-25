import java.util.Random;
import java.util.Scanner;

public class Jogos {
    private Random r = new Random();
    private Scanner input = new Scanner(System.in);

    public void imparOuPar(Conta conta) {
        System.out.print("Você escolheu 'Ímpar ou par', quanto deseja apostar? R$");
        double aposta = Double.parseDouble(input.nextLine());

        if (aposta > conta.getSaldo()) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        int escolha = 0;

        while (true) {
            System.out.print("Escolha entre: 1 = Ímpar | 2 = Par: ");
            String entrada = input.nextLine();
            try {
                escolha = Integer.parseInt(entrada);
                if (escolha != 1 && escolha != 2) {
                    System.out.println("Escolha inválida. Digite 1 ou 2.");
                } else {
                    break; // escolha válida
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        int numero = r.nextInt(100)+1;

        String esc[] = {"ímpar", "par"};

    System.out.println("O número sorteado foi " + numero + " e você escolheu: " + esc[escolha-1]);

        boolean venceu = (numero % 2 == 0 && escolha == 2) || (numero % 2 != 0 && escolha == 1);

        if (venceu) {
            conta.depositar(aposta * 2);
            System.out.println("Você ganhou R$"+(aposta * 2));
        } else {
            conta.perder(aposta);
            System.out.println("Você perdeu R$"+aposta);
        }
    }

    public void pedraPapelTesoura(Conta conta) {
        System.out.print("Você escolheu 'Pedra, Papel e Tesoura', quanto deseja apostar? R$");
        double aposta = Double.parseDouble(input.nextLine());

        if (aposta > conta.getSaldo()){
            System.out.println("Saldo insuficiente.");
            return;
        }

        int escolha = 0;

        while (true) {
            System.out.print("Escolha entre: 1 - Pedra | 2 - Papel | 3 - Tesoura: ");
            String entrada = input.nextLine();
            try {
                escolha = Integer.parseInt(entrada);
                if (escolha < 1 && escolha > 3) {
                    System.out.println("Escolha inválida. Digite 1, 2 ou 3.");
                } else {
                    break; // escolha válida
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        int pc = r.nextInt(3)+1;

        String esc[] = {"pedra", "papel", "tesoura"};

        if (escolha == pc) {
            System.out.println("Empate!!! Você escolheu " + esc[escolha-1] + " e o computador escolheu" + esc[pc-1] + ".");
            return;
        }

        boolean venceu = (escolha == 1 && pc == 3) ||
                         (escolha == 2 && pc == 1) ||
                         (escolha == 3 && pc == 2);

        if (venceu) {
            conta.depositar(aposta * 3);
            System.out.println("Você escolheu " + esc[escolha-1] + " e o computador escolheu" + esc[pc-1] + ". Parabéns, você ganhou R$:" + (aposta * 3));
        } else {
            conta.perder(aposta);
            System.out.println("Você escolheu " + esc[escolha-1] + " e o computador escolheu" + esc[pc-1] + ". Que pena, você perdeu R$:" + (aposta));
        }
    }

    public void adivinheNumero(Conta conta){
        System.out.print("Você escolheu 'Adivinhe o número', quanto deseja apostar? R$");
        double aposta = Double.parseDouble(input.nextLine());

        if (aposta > conta.getSaldo()) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        int escolha = 0;

        while (true) {
            System.out.print("Escolha um número de 1 a 5: ");
            String entrada = input.nextLine();
            try {
                escolha = Integer.parseInt(entrada);
                if (escolha < 1 && escolha > 5) {
                    System.out.println("Escolha inválida. Digite um número entre 1 e 5.");
                } else {
                    break; // escolha válida
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        int numero = r.nextInt(5)+1;

        if (escolha == numero) {
            conta.depositar(aposta * 5);
            System.out.println("Parabéns, você acertou! O número era " + numero + ". Você ganhou R$" + (aposta * 5));
        } else {
            conta.perder(aposta);
            System.out.println("Que pena, você errou! O número era " + numero + ". Você perdeu R$" + (aposta));
        }
    }
}
