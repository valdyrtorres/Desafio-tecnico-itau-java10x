package dev.java10x.itauJava10x;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    // salvar os dados em uma lista
    public void salvarDados(TransacaoRequest transacaoRequest) {
        listaDeTransacoes.add(transacaoRequest);
    }

    // APAGAR ESSA LISTA DEPOIS DE 60 SEGUNDOS
    public void limparDados(TransacaoRequest transacaoRequest) {

    }

    // APAGAR TODAS AS TRANSAÇÕES DA LISTA
    public void deletarDados() {
        listaDeTransacoes.clear();
    }

}
