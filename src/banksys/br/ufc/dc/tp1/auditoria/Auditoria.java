package banksys.br.ufc.dc.tp1.auditoria;

import banksys.br.ufc.dc.tp1.banco.BancoIndependente;
import banksys.br.ufc.dc.tp1.conta.Conta;
import banksys.br.ufc.dc.tp1.conta.ContaAbstrata;
import banksys.br.ufc.dc.tp1.repositorio.RepositorioContaArray;
import banksys.br.ufc.dc.tp1.repositorio.RepositorioContaVector;

public class Auditoria {

    public static void main(String[] args){
        BancoIndependente bancoArray = new BancoIndependente(new RepositorioContaArray());
        BancoIndependente bancoVector = new BancoIndependente(new RepositorioContaVector());

        ContaAbstrata contaA = new Conta("123");
        bancoArray.cadastrar(contaA);
        bancoArray.creditar("123", 501);

        AuditorBancoGenerico auditor = new AuditorBancoGenerico();

        auditor.auditar(bancoArray);
        auditor.auditar(bancoVector);
    }
}