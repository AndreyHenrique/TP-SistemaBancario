package banksys.br.ufc.dc.tp1.banco;

import banksys.br.ufc.dc.tp1.conta.ContaAbstrata;

public interface IBanco {
    int numeroContas();

    double saldoTotal();

    void cadastrar(ContaAbstrata conta);

    ContaAbstrata procurar(String numeroConta);

    void debitar(String numero, double valor);

    void creditar(String numero, double valor);

    void transferir(String numeroA, String numeroB, double valor);

    void renderJuros(String numero);

    void renderBonus(String numero);
}