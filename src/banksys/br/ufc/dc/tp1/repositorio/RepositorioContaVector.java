package banksys.br.ufc.dc.tp1.repositorio;

import banksys.br.ufc.dc.tp1.conta.ContaAbstrata;

import java.util.Vector;

public class RepositorioContaVector implements IRepositorioConta{
    private final Vector<ContaAbstrata> contas;

    public  RepositorioContaVector() {
        contas = new Vector<>();
    }

    @Override
    public void inserir(ContaAbstrata conta) {
        contas.add(conta);
    }

    @Override
    public void remover(String numero) {
        ContaAbstrata contaAchada = procurar(numero);
        contas.remove(contaAchada);
    }

    @Override
    public ContaAbstrata procurar(String numero) {
        int i = 0;
        boolean achou = false;

        while ((!achou) && (i < contas.size())) {
            String numeroContaAchada = contas.get(i).getNumero();
            if (numeroContaAchada.equals(numero)) {
                achou = true;
            }
            else {
                i ++;
            }
        }

        if (achou){
            return contas.get(i);
        }
        else { return null; }
    }

    @Override
    public ContaAbstrata[] listar() {
        return contas.toArray(ContaAbstrata[]::new);
    }

    @Override
    public int tamanho() {
        return contas.size();
    }
}
