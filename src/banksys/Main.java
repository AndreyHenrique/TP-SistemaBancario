package banksys;

import banksys.br.ufc.dc.tp1.banco.BancoVector;
import banksys.br.ufc.dc.tp1.conta.Conta;
import banksys.br.ufc.dc.tp1.conta.ContaPoupanca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        ContaPoupanca c = new ContaPoupanca("12345");
        Conta d = new Conta("11111");

        BancoVector banco_a = new BancoVector();
        banco_a.cadastrar(c);
        banco_a.cadastrar(d);

        banco_a.creditar("12345", 1000);
        banco_a.creditar("11111", 500);
        banco_a.debitar("11111", 100);
        banco_a.transferir("11111", "12345", 400);

        c.renderJuros(0.01);

        c.mostrarConta();
        d.mostrarConta();
    }
}
