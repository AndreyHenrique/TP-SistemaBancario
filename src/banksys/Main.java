package banksys;

import banksys.br.ufc.dc.tp1.banco.Banco;
import banksys.br.ufc.dc.tp1.banco.BancoVector;

import banksys.br.ufc.dc.tp1.conta.Conta;
import banksys.br.ufc.dc.tp1.conta.ContaEspecial;
import banksys.br.ufc.dc.tp1.conta.ContaPoupanca;

public class Main {

    public static void main(String[] args) {
        ContaPoupanca c = new ContaPoupanca("12345");
        Conta d = new Conta("11111");

        Banco banco_a = new Banco(); 
        
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
        BancoVector bancoB = new BancoVector();
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
    }
}
