public class Conta {
    private double saldo;

    public Conta() {
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar (double valor){
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }else{
            System.out.println("Valor inválido.");
        }
    }

    public void sacar (double valor){
        if (valor > saldo || valor <= 0){
            System.out.println("Saldo insuficiente ou valor inválido.");
        }else{
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    public void perder (double valor) {
        if (valor == saldo) {
            saldo = 0;
        } else {
            saldo -= valor;
        }
    }
}
