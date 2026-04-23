package banksys.br.ufc.dc.tp1.conta;

public abstract class ContaAbstrata {
    protected String numero;
    protected double saldo;

    public ContaAbstrata (String numero) {
        this.numero = numero;
        saldo = 0;
    }

    public void creditar (double valor) {
        this.saldo += valor;
    }

    public abstract void debitar (double valor);

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