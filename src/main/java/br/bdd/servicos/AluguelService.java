package br.bdd.servicos;

import br.bdd.entidades.Filme;
import br.bdd.entidades.NotaAluguel;
import br.bdd.entidades.TipoAluguel;
import br.bdd.utils.DateUtils;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
        if (filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque");
        NotaAluguel nota = new NotaAluguel();

        switch (tipo) {
            case COMUM:
                nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(1));
                nota.setPreco(filme.getAluguel());
                nota.setPontuacao(1);
                break;
            case SEMANAL:
                nota.setPreco(filme.getAluguel() * 3);
                //utilizando a classe date do pacote utils
                nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(7));
                nota.setPontuacao(3);
                break;
            case EXTENDIDO:
                nota.setPreco(filme.getAluguel() * 2);
                //utilizando a classe date do pacote utils
                nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(3));
                nota.setPontuacao(2);
                break;
        }
        //subtituído pelo switch acima
        //        //se for extendido o valor vai ser dobrado
//        if ("extendido".equals(tipo)) {
//            nota.setPreco(filme.getAluguel() * 2);
//            //utilizando a classe date do pacote utils
//            nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(3));
//            nota.setPontuacao(2);
//        } else if ("semanal".equals(tipo)) {
//            nota.setPreco(filme.getAluguel() * 3);
//            //utilizando a classe date do pacote utils
//            nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(7));
//            nota.setPontuacao(3);
//        } else {
//            //utilizando a classe date do pacote utils
//            nota.setDataEntrega(DateUtils.obterDadaDiferencaDias(1));
//            nota.setPreco(filme.getAluguel());
//            nota.setPontuacao(1);
//        }

        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
