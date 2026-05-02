package banksys.br.ufc.dc.tp1.banco;

import banksys.br.ufc.dc.tp1.conta.ContaAbstrata;
import banksys.br.ufc.dc.tp1.conta.ContaEspecial;
import banksys.br.ufc.dc.tp1.conta.ContaPoupanca;
import banksys.br.ufc.dc.tp1.repositorio.IRepositorioConta;

public class BancoIndependente implements IBanco {
    private final IRepositorioConta contas;

    public BancoIndependente(IRepositorioConta contas) {
        this.contas = contas;
    }

    public double saldoTotal() {
        ContaAbstrata[] listadeContas = contas.listar();
        double soma = 0;
        for (ContaAbstrata conta : listadeContas){
            soma += conta.getSaldo();
        }
        return soma;
    }

    public int numeroContas() { return contas.tamanho(); }

    public void cadastrar(ContaAbstrata conta) {
        contas.inserir(conta);
    }

    public ContaAbstrata procurar(String numero) {
        return contas.procurar(numero);
    }

    public void debitar(String numero, double valor) {
    	ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            conta.debitar(valor);
        }
        else System.out.println("A conta não existe.");
    }

    public void creditar(String numero, double valor) {
    	ContaAbstrata conta = procurar(numero);
        if (conta != null) {
            conta.creditar(valor);
        }
        else System.out.println("A conta não existe.");
    }

    public void transferir(String numeroA, String numeroB, double valor) {
    	ContaAbstrata contaA = procurar(numeroA);
    	ContaAbstrata contaB = procurar(numeroB);

        if (contaA == null || contaB == null) {
            System.out.println("A conta não existe");
        }
        debitar(numeroA, valor);
        creditar(numeroB, valor);
    }
    
    public void renderJuros(String numero) {
    	ContaAbstrata contaAchada = this.procurar(numero);
    	if (contaAchada instanceof ContaPoupanca)
    	{
    		((ContaPoupanca) contaAchada).renderJuros(0.01);
    	}
    	else {
    		System.out.println("Conta não é conta de poupança.");
    	}
    	
    }
    
    public void renderBonus(String numero) {
    	ContaAbstrata contaAchada = this.procurar(numero);
    	if (contaAchada instanceof ContaEspecial)
    	{
    		((ContaEspecial) contaAchada).renderBonus();
    	}
    	else {
    		System.out.println("Conta não é conta especial.");
    	}
    }
}
