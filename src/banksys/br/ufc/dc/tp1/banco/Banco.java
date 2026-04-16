package banksys.br.ufc.dc.tp1.banco;

import banksys.br.ufc.dc.tp1.conta.Conta;
import banksys.br.ufc.dc.tp1.conta.ContaEspecial;
import banksys.br.ufc.dc.tp1.conta.ContaPoupanca;

public class Banco {
    private Conta[] contas;
    private int indice = 0;

    public Banco() {
        contas = new Conta[100];
    }

    public void cadastrar(Conta conta) {
        contas[indice] = conta;
        indice ++;
    }

    private Conta procurar(String numeroConta) {
        int i = 0;
        boolean achou = false;

        while ((!achou) && (i < indice)) {
            String numeroContaAchada = contas[i].getNumero();
            if (numeroContaAchada.equals(numeroConta)) {
                achou = true;
            }
            else {
                i ++;
            }
        }

        if (achou){
            return contas[i];
        }
        else { return null; }
    }

    public void debitar(String numero, double valor) {
        Conta conta = procurar(numero);
        if (conta != null) {
            conta.debitar(valor);
        }
        else System.out.println("A conta não existe.");
    }

    public void creditar(String numero, double valor) {
        Conta conta = procurar(numero);
        if (conta != null) {
            conta.creditar(valor);
        }
        else System.out.println("A conta não existe.");
    }

    public void transferir(String numeroA, String numeroB, double valor) {
        Conta contaA = procurar(numeroA);
        Conta contaB = procurar(numeroB);

        if (contaA == null || contaB == null) {
            System.out.println("A conta não existe");
        }
        debitar(numeroA, valor);
        creditar(numeroB, valor);
    }
    
    public void renderJuros(String numero) {
    	Conta contaAchada = this.procurar(numero);
    	if (contaAchada instanceof ContaPoupanca)
    	{
    		((ContaPoupanca) contaAchada).renderJuros(0.01);
    	}
    	else {
    		System.out.println("Conta não é conta de poupança.");
    	}
    	
    }
    
    public void renderBonus(String numero) {
    	Conta contaAchada = this.procurar(numero);
    	if (contaAchada instanceof ContaEspecial)
    	{
    		((ContaEspecial) contaAchada).renderBonus();
    	}
    	else {
    		System.out.println("Conta não é conta especial.");
    	}
    }
}
