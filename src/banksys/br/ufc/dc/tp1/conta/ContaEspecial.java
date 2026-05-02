package banksys.br.ufc.dc.tp1.conta;

public class ContaEspecial extends Conta{
	private double bonus;
	
	public ContaEspecial(String numero) {
		super(numero);
		this.bonus = 0;
	}
	public void renderBonus() {
		super.creditar(bonus);
		bonus = 0;
	}
	
	public void creditar(double valor) {
		bonus = bonus + (valor * 0.01);
		super.creditar(valor);
	}
}
