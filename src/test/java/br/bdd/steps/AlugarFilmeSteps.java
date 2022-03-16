package br.bdd.steps;

import br.bdd.entidades.Filme;
import br.bdd.entidades.NotaAluguel;
import br.bdd.servicos.AluguelService;
import br.bdd.utils.DateUtils;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {

    //importando a classe
    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private String tipoAluguel;

    @Dado("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int arg1) {
        filme = new Filme();
        filme.setEstoque(arg1);
    }

    @Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDoAluguelSejaR$(int arg1) {
        filme.setAluguel(arg1);
    }

    @Quando("^alugar$")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }

    }

    @Então("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(int arg1) {
        Assert.assertEquals(arg1, nota.getPreco());
    }

//    @Então("^a data de entrega será no dia seguinte$")
//    public void aDataDeEntregaSeráNoDiaSeguinte() {
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, 1);
//
//        //setando a data de retorno dentro da instância do calendar
//        Date dataRetorno = nota.getDataEntrega();
//        Calendar calRetorno = Calendar.getInstance();
//        calRetorno.setTime(dataRetorno);
//
//        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
//        Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
//        Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
//    }

    @Então("^o estoque do filme será (\\d+) unidade$")
    public void oEstoqueDoFilmeSeráUnidade(int arg1) {
        Assert.assertEquals(arg1, filme.getEstoque());
    }
    //cenário de filme sem estoque
    @Então("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    //cenário extendido

    @Dado("^que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo;
    }

    @Então("^a data entrega será em (\\d+) dias?$")
    public void aDataEntregaSeráEmDias(int arg1) {
        Date dataEsperada = DateUtils.obterDadaDiferencaDias(arg1);
        Date dataReal = nota.getDataEntrega();

        //remove a hora,minutos e segundos para que seja comprado apenas as datas
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("^a pontuação será de (\\d+) pontos$")
    public void aPontuaçãoSeráDePontos(int arg1) {
        Assert.assertEquals(arg1, nota.getPontuacao());
    }
}
