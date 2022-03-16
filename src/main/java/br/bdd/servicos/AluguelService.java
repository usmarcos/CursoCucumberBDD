package br.bdd.servicos;

import br.bdd.entidades.Filme;
import br.bdd.entidades.NotaAluguel;
import br.bdd.utils.DateUtils;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme) {
        if (filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        //utilizando a classe date do pacote utils
        nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(1));
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
