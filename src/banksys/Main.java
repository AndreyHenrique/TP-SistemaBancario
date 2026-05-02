package banksys;

import banksys.br.ufc.dc.tp1.banco.BancoIndependente;
import banksys.br.ufc.dc.tp1.conta.Conta;
import banksys.br.ufc.dc.tp1.conta.ContaEspecial;
import banksys.br.ufc.dc.tp1.conta.ContaPoupanca;
import banksys.br.ufc.dc.tp1.conta.ContaImposto;
import banksys.br.ufc.dc.tp1.repositorio.RepositorioContaArray;
import banksys.br.ufc.dc.tp1.repositorio.RepositorioContaVector;

public class Main {

    public static void main(String[] args) {
        ContaPoupanca c = new ContaPoupanca("12345");
        Conta d = new Conta("11111");
        

        BancoIndependente banco_a = new BancoIndependente(new RepositorioContaArray());
        
        banco_a.cadastrar(c);
        banco_a.cadastrar(d);
        banco_a.creditar("12345", 1000);
        banco_a.creditar("11111", 500);
        banco_a.debitar("11111", 100);
        banco_a.transferir("11111", "12345", 400);
        
        

        c.renderJuros(0.01);

        c.mostrarConta();
        d.mostrarConta();
        
        
        // teste de juros e bonus
        BancoIndependente bancoB = new BancoIndependente(new RepositorioContaVector());
        ContaPoupanca contaPoupanca = new ContaPoupanca("12");
        ContaEspecial contaEspecial = new ContaEspecial("21");
        
        bancoB.cadastrar(contaPoupanca);
        bancoB.cadastrar(contaEspecial);
        
        bancoB.creditar("12", 10000);
        bancoB.creditar("21", 10000);
        
        bancoB.renderJuros("12");
        bancoB.renderBonus("21");
        
        contaPoupanca.mostrarConta();
        contaEspecial.mostrarConta();
        
        // teste de conta imposto 
        System.out.println("=|=|=|=|=|=|=|TESTES CONTA IMPOSTO =|=|=|=|=|=|=|");
        ContaImposto contaImp = new ContaImposto("66");
        contaImp.mostrarConta();
        
        bancoB.cadastrar(contaImp);
        bancoB.creditar("66", 100000);
        bancoB.debitar("66", 2000);
        contaImp.mostrarConta();
    }
}
