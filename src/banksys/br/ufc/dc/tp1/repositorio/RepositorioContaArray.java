package banksys.br.ufc.dc.tp1.repositorio;

import banksys.br.ufc.dc.tp1.conta.ContaAbstrata;

import java.util.Arrays;
import java.util.Objects;

public class RepositorioContaArray implements IRepositorioConta{
    final ContaAbstrata[] contas;
    private int indice = 0;

    public RepositorioContaArray() {
        contas = new ContaAbstrata[100];
    }

    @Override
    public void inserir(ContaAbstrata conta) {
        contas[indice] = conta;
        indice ++;
    }

    @Override
    public void remover(String numero) {
        for (int i = 0; i < indice; i++) {
            if (contas[i].getNumero().equals(numero)) {
                // Move o último elemento para a posição do removido
                contas[i] = contas[indice - 1];
                contas[indice - 1] = null;
                indice--;
                return; // Sai do método após remover
            }
        }
    }

    @Override
    public ContaAbstrata procurar(String numero) {
        int i = 0;
        boolean achou = false;

        while ((!achou) && (i < indice)) {
            String numeroContaAchada = contas[i].getNumero();
            if (numeroContaAchada.equals(numero)) {
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

    @Override
    public ContaAbstrata[] listar() {
        return Arrays.stream(contas)
                .filter(Objects::nonNull)
                .toArray(ContaAbstrata[]::new);
    }

    @Override
    public int tamanho() {
        return indice;
    }
}
