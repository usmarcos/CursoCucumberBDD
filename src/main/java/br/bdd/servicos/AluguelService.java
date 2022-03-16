package br.bdd.servicos;

import br.bdd.entidades.Filme;
import br.bdd.entidades.NotaAluguel;
import br.bdd.utils.DateUtils;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, String tipo) {
        if (filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();
        //se for extendido o valor vai ser dobrado
        if ("extendido".equals(tipo)) {
            nota.setPreco(filme.getAluguel() * 2);
            //utilizando a classe date do pacote utils
            nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(3));
            nota.setPontuacao(2);
        } else {
            //utilizando a classe date do pacote utils
            nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(1));
            nota.setPreco(filme.getAluguel());
            nota.setPontuacao(1);
        }
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
