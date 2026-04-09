package banksys.br.ufc.dc.tp1.conta;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(String numero) {
        super(numero);

    }

    public void renderJuros(double taxas) {
        creditar(getSaldo() * taxas);
    }
}
