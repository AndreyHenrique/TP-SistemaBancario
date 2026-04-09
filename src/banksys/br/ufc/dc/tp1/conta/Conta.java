package banksys.br.ufc.dc.tp1.conta;

public class Conta {
    private String numero;
    private double saldo;

    public Conta (String numero) {
        this.numero = numero;
        saldo = 0;
    }

    public void creditar (double valor) {
        this.saldo += valor;
    }

    public void debitar (double valor) {
        this.saldo -= valor;
    }

    public void mostrarConta() {
        System.out.println("O saldo da conta " + getNumero() + " é de: R$" + getSaldo());
    }

    public String getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
