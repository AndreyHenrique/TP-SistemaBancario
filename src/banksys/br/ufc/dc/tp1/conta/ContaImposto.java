package banksys.br.ufc.dc.tp1.conta;

public class ContaImposto extends ContaAbstrata{
	
    public ContaImposto (String numero) {
        super(numero);
    }
    
    public void debitar (double valor) {
        saldo -= valor + ( valor * 0.001);
    }
}