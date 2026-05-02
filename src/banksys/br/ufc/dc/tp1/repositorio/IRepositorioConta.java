package banksys.br.ufc.dc.tp1.repositorio;

import banksys.br.ufc.dc.tp1.conta.ContaAbstrata;

public interface IRepositorioConta {

    void inserir(ContaAbstrata conta);
    void remover(String numero);
    ContaAbstrata procurar(String numero);
    ContaAbstrata[] listar();
    int tamanho();
}
