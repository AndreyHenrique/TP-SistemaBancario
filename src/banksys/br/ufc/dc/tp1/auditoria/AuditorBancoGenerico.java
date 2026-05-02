package banksys.br.ufc.dc.tp1.auditoria;

import banksys.br.ufc.dc.tp1.banco.IBanco;

public class AuditorBancoGenerico {
    public void auditar(IBanco banco) {
        if (banco.numeroContas() == 0 ){
            System.out.println("O banco não está aprovado.");
        }
        else {
            if ((banco.saldoTotal() / banco.numeroContas()) > 500) System.out.println("O banco está aprovado!");
            else System.out.println("O banco não está aprovado.");
        }
    }
}
