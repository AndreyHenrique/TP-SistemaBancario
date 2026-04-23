package banksys.br.ufc.dc.tp1.conta;

public class Conta extends ContaAbstrata {

    public Conta (String numero) {
        super(numero);
    }
    
    public void debitar (double valor) {
        saldo -= valor;
    }
}
